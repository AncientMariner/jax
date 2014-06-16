package rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;

@Path("/pdf")
public class PdfService {
    private static final String FILE_PATH = "/home/xander/IdeaProjects/jax/jsr339-jaxrs-2.0-final-spec.pdf";

    @GET
    @Path("/get")
    @Produces("application/pdf")
    public Response getFile() {
        File file = new File(FILE_PATH);

        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename=jsr339-jaxrs-2.0-final-spec.pdf");
        return response.build();
    }
}
