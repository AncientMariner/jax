package rest.standalone;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToJsonFileExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "alex");
        map.put("age", 10);

        List<Object> list = new ArrayList<Object>();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        map.put("messages", list);

        final String FILE_PATH = "/home/xander/IdeaProjects/jax/user.json";
        try {
            // write JSON to a file
            mapper.writeValue(new File(FILE_PATH), map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}