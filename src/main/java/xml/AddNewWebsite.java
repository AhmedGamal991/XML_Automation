package xml;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.Calendar;

public class AddNewWebsite {

	public static void main(String[] args) {
		try {
			Websites websites = DeserializeXML.deserializeXML();
			
			Website newWebsite = new Website();
			newWebsite.setUrl("https://www.sephora4.sg/");
			newWebsite.setTitle("Sephora Singapore 4");
			newWebsite.setDescription("Sephora, where beauty beats. Discover the best in makeup, skin care, and more from a wide selection of beauty brands. Free shipping for orders above S$40.");
			Calendar calendar = Calendar.getInstance();
	    	calendar.set(2019, 10, 20);
			newWebsite.setCreatedDate(calendar.getTime());
			websites.getWebsites().add(newWebsite);
	
			XmlMapper xmlMapper = new XmlMapper();
			File xmlFile = new File(DeserializeXML.XML_PATH);
			xmlMapper.writerWithDefaultPrettyPrinter().writeValue(xmlFile, websites);
			
			websites = DeserializeXML.deserializeXML();

	    	System.out.println("All Websites after adding a new website:\n");

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
