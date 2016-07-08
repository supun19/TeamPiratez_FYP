package com.sample;

public class Triangle extends GeoItem {

	public Point points[];
	
	public Triangle(Point a, Point b, Point c){
		super(GeoType.TRIANGLE);
		points = new Point[3];
		
		points[0] = a;
		points[1] = b;
		points[2] = c;
		
	}
}
