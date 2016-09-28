package com.sample;



public class Line extends GeoItem {

	public Point[] endPoints;
	public String name;
	
	public Line(Point point0, Point point1 ) {
		
		super(GeoType.LINE);
		endPoints = new Point[2];			
		endPoints[0] = point0;
		endPoints[1] = point1;
		name = this.getName();
		
	}

	public Boolean sameItem(GeoItem item){
		
		if ( item.type != GeoType.LINE) return false;
		
		if (getName().matches(((Line)item).getName())) return true;
		
		return false;
		
	}
	
	public String getName(){
		
			
			if (endPoints[0].getName().compareTo(endPoints[1].getName())> 0) {
				
				return  String.valueOf(endPoints[1].name) +  String.valueOf(endPoints[0].name);
	
			}
			else
				return  String.valueOf(endPoints[0].name) +  String.valueOf(endPoints[1].name);
			
	}
}
