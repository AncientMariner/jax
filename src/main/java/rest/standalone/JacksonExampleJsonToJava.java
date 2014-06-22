package rest.standalone;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import rest.entity.User;

import java.io.File;
import java.io.IOException;

public class JacksonExampleJsonToJava {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        final String FILE_PATH = "/home/xander/IdeaProjects/jax/user.json";
        try {
            User user = mapper.readValue(new File(FILE_PATH), User.class);

            System.out.println(user);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}