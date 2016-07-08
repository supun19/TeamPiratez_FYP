package com.sample;

public class Angle extends GeoItem{
	
	public Point pointOne;
	public Point pointThree;
	public Point middle;
	
	public int num;

	public Angle(Point one, Point middle, Point three) {
		
		super(GeoType.ANGLE);
		
		this.pointOne = one;
		this.pointThree = three;
		this.middle = middle;
		num = 1;
		
	}
	
	public boolean isMiddleElement(char pointName){
		return middle.name == pointName;
	}
	
	public boolean isACornerPoint(char pointName){
		return ( pointOne.name == pointName || pointThree.name == pointName );
	}

}
