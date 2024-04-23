package xml;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertToJson {

	public static void main(String[] args) {
		try {
			Websites websites = DeserializeXML.deserializeXML();

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(websites);

	    	System.out.println("All Websites in JSON format:\n");

	    	System.out.println(json);
		} catch (IOException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		}
	}

}
