package com.sample;



public abstract class GeoItem {
	public GeoType type;
	public String name;
	
	public GeoItem(GeoType type){
		this.type = type;
	}
	
	public abstract Boolean sameItem(GeoItem item);

	public abstract String getName();

}
