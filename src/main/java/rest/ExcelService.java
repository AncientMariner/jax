package rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;

@Path("/excel")
public class ExcelService {
    private static final String FILE_PATH = "/home/xander/IdeaProjects/jax/excel.xls";

    @GET
    @Path("/get")
    @Produces("application/vnd.ms-excel")
    public Response getFile() {

        File file = new File(FILE_PATH);

        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename=new-excel-file.xls");
        return response.build();
    }
}
