package rest;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class MapToJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json;

            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "alex");
            map.put("age", "10");

            //convert map to JSON string
            json = mapper.writeValueAsString(map);

            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}