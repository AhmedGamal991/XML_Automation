package xml;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Websites {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("Website")
    private List<Website> websites = new ArrayList<>();

	public List<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}
}
