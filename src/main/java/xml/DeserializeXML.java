package xml;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class DeserializeXML {

	public static String XML_PATH = "src/main/resources/websites.xml";

	public static Websites deserializeXML() throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		File xmlFile = new File(XML_PATH);
		Websites websites = xmlMapper.readValue(xmlFile, Websites.class);
		return websites;
	}

	public static void main(String[] args) {
		try {
			Websites websites = deserializeXML();

		    for (int i = 0; i < websites.getWebsites().size(); i++) {
		    	System.out.println("Website " + (i + 1) + ":");
		    	System.out.println("URL: " + websites.getWebsites().get(i).getUrl());
			    System.out.println("Title: " + websites.getWebsites().get(i).getTitle());
			    System.out.println("Description: " + websites.getWebsites().get(i).getDescription());
			    System.out.println("Created Date: " + websites.getWebsites().get(i).getCreatedDate());
			    System.out.println();
			}
		} catch (IOException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		}
	}

}
