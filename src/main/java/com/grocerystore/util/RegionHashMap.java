package com.grocerystore.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class encapsulates cityRegion to reduce the database burden.
 * 
 * See Customer's cityRegion field.
 */
public class RegionHashMap {

	private Map<String, String> cityRegion;
	
	public RegionHashMap() {
		cityRegion = new LinkedHashMap<String, String>();
		cityRegion.put("PG", "Miền Bắc");
		cityRegion.put("BN", "Miền Trung");
		cityRegion.put("HS", "Miền Nam");
	}

	public Map<String, String> getCityRegion() {
		return cityRegion;
	}
	
}
