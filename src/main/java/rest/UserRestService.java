package rest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/users")
public class UserRestService {
    @GET
    public Response getUser() {
        return Response.status(OK).entity("getUser is called").build();
    }

    @GET
    @Path("/vip")
    public Response getUserVIP() {
        return Response.status(OK).entity("getUserVIP is called").build();
    }

    @GET
    @Path("{name}")
    public Response getUserByName(@PathParam("name") String name) {

        return Response.status(OK)
                .entity("getUserByName is called, name : " + name).build();
    }

    @GET
    @Path("{id : \\d+}") //support digit only
    public Response getUserById(@PathParam("id") String id) {
        return Response.status(OK).entity("getUserById is called, id : " + id).build();
    }

    @GET
    @Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
    public Response getUserByUserName(@PathParam("username") String username) {
        return Response.status(OK)
                .entity("getUserByUserName is called, username : " + username).build();
    }

    @GET
    @Path("/books/{isbn : \\d+}")
    public Response getUserBookByISBN(@PathParam("isbn") String isbn) {
        return Response.status(OK)
                .entity("getUserBookByISBN is called, isbn : " + isbn).build();
    }

    @GET
    @Path("/getUserAgent")
    public Response addUser(@HeaderParam("user-agent") String userAgent) {

        return Response.status(OK)
                .entity("addUser is called, userAgent : " + userAgent)
                .build();
    }

    @GET
    @Path("/getHeaders")
    public Response addUser(@Context HttpHeaders headers) {
        String userAgent = headers.getRequestHeader("user-agent").get(0);

        for(String header : headers.getRequestHeaders().keySet()){
            System.out.println(header);
        }

        return Response.status(OK)
                .entity("addUser is called, userAgent : " + userAgent)
                .build();
    }
}