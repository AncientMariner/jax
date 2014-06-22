package rest.standalone;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class JsonFileToMapExample {
    public static void main(String[] args) {
        final String FILE_PATH = "/home/xander/IdeaProjects/jax/user.json";
        try {
            ObjectMapper mapper = new ObjectMapper();

            // read JSON from a file
            Map<String, Object> map = mapper.readValue(
                    new File(FILE_PATH),
                    new TypeReference<Map<String, Object>>() {
                    });

            System.out.println(map.get("name"));
            System.out.println(map.get("age"));

            @SuppressWarnings("unchecked")
            ArrayList<String> list = (ArrayList<String>) map.get("messages");

            for (String msg : list) {
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}