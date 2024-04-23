package xml;

import java.io.IOException;

public class PrintAll {

	public static void main(String[] args) {
		try {
			Websites websites = DeserializeXML.deserializeXML();

	    	System.out.println("All Websites:\n");

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
