package jdt.quarkus.plugin.handlers;

import org.eclipse.lsp4j.Location;

public class PropertyDefinition {

	private String propertySource;
	
	private Location location;

	public String getPropertySource() {
		return propertySource;
	}

	public void setPropertySource(String propertySource) {
		this.propertySource = propertySource;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
