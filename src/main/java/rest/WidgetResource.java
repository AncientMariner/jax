package rest;

import javax.ws.rs.GET;

public class WidgetResource {
    String id;

    public WidgetResource(String id) {
        this.id = id;
    }

    @GET
    public String getId() {
        return id;
    }
}
