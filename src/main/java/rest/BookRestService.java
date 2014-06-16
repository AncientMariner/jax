package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/books")
public class BookRestService {
    @GET
    @Path("{id}")
    public Response getBookById(@PathParam("id") String id) {
        return Response.status(OK).entity("getBookById is called, id : " + id).build();
    }

    @GET
    @Path("{year}/{month}/{day}")
    public Response getBookHistory(
            @PathParam("year") int year,
            @PathParam("month") int month,
            @PathParam("day") int day) {

        String date = year + "/" + month + "/" + day;

        return Response.status(OK)
                .entity("getBookHistory is called, year/month/day : " + date)
                .build();
    }
}