package rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/cars")
public class CarRestService {
    @GET
    @Path("/query")
    public Response getCars(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") List<String> orderBy) {
        return Response
                .status(OK)
                .entity("getUsers is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();
    }

    //q?from=100&to=200&orderBy=age&orderBy=name
    @GET
    @Path("/q")
    public Response getUsers(@Context UriInfo info) {
        String from = info.getQueryParameters().getFirst("from");
        String to = info.getQueryParameters().getFirst("to");
        List<String> orderBy = info.getQueryParameters().get("orderBy");

        return Response
                .status(OK)
                .entity("getUsers programmatically is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();
    }

    @GET
    @Path("/default")
    public Response getUsers(
            @DefaultValue("1000") @QueryParam("from") int from,
            @DefaultValue("999")@QueryParam("to") int to,
            @DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {
        return Response
                .status(OK)
                .entity("getUsers by default is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();
    }
}