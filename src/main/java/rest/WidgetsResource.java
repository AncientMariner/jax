package rest;

import rest.entity.WidgetResource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/widgets")
public class WidgetsResource {
    @Path("{id}")
    public WidgetResource findWidget(@PathParam("id") String id) {
        return new WidgetResource(id);
    }
}
