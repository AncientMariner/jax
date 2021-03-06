package rest;

import rest.entity.Track;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;

@Path("/json/metallica")
public class JSONService {
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {
        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");
        return track;
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_XML)
    public Track getTrackInXML() {
        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");
        return track;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {
        String result = "Track saved : " + track;
        return Response.status(CREATED).entity(result).build();
    }
}