package com.sample;

public class Triangle extends GeoItem {

    public Point points[];
    public Line lines[];
    public Angle angles[];
    
    public Triangle(Point a, Point b, Point c){
        super(GeoType.TRIANGLE);
        points = new Point[3];
        lines = new Line[3];
        angles = new Angle[3];
        
        points[0] = a;
        points[1] = b;
        points[2] = c;
        
        lines[0] = new Line(a, b);
        lines[1] = new Line(b, c);
        lines[2] = new Line(a, c);
        
        angles[0] = new Angle(lines[0], lines[1]);
        angles[1] = new Angle(lines[1], lines[2]);
        angles[2] = new Angle(lines[2], lines[0]);
        
    }

	public Boolean sameItem(GeoItem item){
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
