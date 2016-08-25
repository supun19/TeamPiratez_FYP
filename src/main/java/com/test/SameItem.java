package com.test;

import com.sample.Line;
import com.sample.Point;

public class SameItem {

	public static void main(String args[]){


		
		Point p1 = new Point('A');
		Point p2 = new Point('B');
		Point p3 = new Point('A');
		Point pc = new Point('C');
		
		Line ab = new Line(p1, p2);
		Line ba = new Line(p2, p1);
		Line bc = new Line(p2, pc);
		
		
		
		System.out.println(p1.sameItem(p3));
		System.out.println(ab.sameItem(ba));
		System.out.println(ab.sameItem(bc));
		//System.out.println(ab.getName());
		//System.out.println(ba.getName());

	}

}
