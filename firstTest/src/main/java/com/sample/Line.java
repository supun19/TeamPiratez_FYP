package com.sample;



public class Line extends GeoItem {

	public Point[] endPoints;
	
	public Line(Point point0, Point point1 ) {
		
		super(GeoType.LINE);
		endPoints = new Point[2];			
		endPoints[0] = point0;
		endPoints[1] = point1;
		
	}

}
