package rest.standalone;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.util.HashMap;
import java.util.Map;

public class JsonToMapExample {
    public static void main(String[] args) {
        String json = "{\"name\":\"alex\", \"age\":\"10\"}";

        ObjectMapper mapper = new ObjectMapper();

        try {
            //convert JSON string to Map
            Map<String,String> map = mapper.readValue(json, new TypeReference<HashMap<String,String>>(){});

            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}