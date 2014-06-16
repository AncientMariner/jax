package rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/user")
public class FormService {
    @POST
    @Path("/add")
    public Response addUser(
            @FormParam("name") String name,
            @FormParam("age") int age) {
        return Response.status(OK)
                .entity("addUser is called, name : " + name + ", age : " + age)
                .build();
    }
}