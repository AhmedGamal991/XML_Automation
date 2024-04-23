package xml;

import java.io.IOException;
import java.util.Calendar;

public class GetAllAfterDate {

	private static int YEAR = 2019;
	private static int MONTH = 8;
	private static int DAY = 1;

	public static void main(String[] args) {
		try {
			Websites websites = DeserializeXML.deserializeXML();

	    	Calendar calendar = Calendar.getInstance();
	    	calendar.set(YEAR, MONTH, DAY);

	    	System.out.println("All Websites that were created after " + MONTH + '/' + DAY + '/' + YEAR + ":\n");

		    for (int i = 0; i < websites.getWebsites().size(); i++) {
		    	if (websites.getWebsites().get(i).getCreatedDate().before(calendar.getTime())) {
		    		continue;
		    	}
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
