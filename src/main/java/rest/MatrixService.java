package rest;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/cats")
public class MatrixService {
    @GET
    @Path("{year}")
    public Response getBooks(@PathParam("year") String year,
                             @MatrixParam("author") String author,
                             @MatrixParam("country") String country) {
        return Response
                .status(OK)
                .entity("getBooks is called, year : " + year
                        + ", author : " + author + ", country : " + country)
                .build();
    }
}