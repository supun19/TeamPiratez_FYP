package com.sample;

public class Point extends GeoItem{
	
	public char name;

	public Point(char name) {
		
		super(GeoType.POINT);
		
		this.name = name;
		// TODO Auto-generated constructor stub
	}

}
