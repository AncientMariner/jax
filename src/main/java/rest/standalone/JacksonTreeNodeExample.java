package rest.standalone;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class JacksonTreeNodeExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        final String FILE_PATH = "/home/xander/IdeaProjects/jax/user.json";
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(FILE_PATH), Charset.defaultCharset());
//            BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH));
//            JsonNode rootNode = mapper.readTree(fileReader);
            JsonNode rootNode = mapper.readTree(inputStreamReader);

            /*** read ***/
            JsonNode nameNode = rootNode.path("name");
            System.out.println(nameNode.getTextValue());

            JsonNode ageNode = rootNode.path("age");
            System.out.println(ageNode.getIntValue());

            JsonNode msgNode = rootNode.path("messages");
            Iterator<JsonNode> ite = msgNode.getElements();

            while (ite.hasNext()) {
                JsonNode temp = ite.next();
                System.out.println(temp.getTextValue());
            }

            /*** update ***/
            ((ObjectNode) rootNode).put("nickname", "new nickname");
            ((ObjectNode) rootNode).put("name", "updated name");
            ((ObjectNode) rootNode).remove("age");

            mapper.writeValue(new File(FILE_PATH), rootNode);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
