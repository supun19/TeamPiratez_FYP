package com.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.Angle;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;
import com.sample.Triangle;

public class Theorem5Test {
	public static void main(String args[]){
	      try {
	        	
	        	
	  		
	        	
	            // load up the knowledge base
		        KieServices ks = KieServices.Factory.get();
	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	        	KieSession kSession = kContainer.newKieSession("ksession-rules");

	            // go !
	        	Point A= new Point('A');
	        	Point B= new Point('B');
	        	Point C= new Point('C');
	        	Point D= new Point('D');
	        	Point E=new Point('E');
	        	Point F=new Point('F');
	        	Point G=new Point('G');
	        	
	        	Line AB=new Line(A,B);
	        	Line BC=new Line(B,C);
	        	Line CG=new Line(C,G);
	        	
	        	Line DE=new Line(D,E);
	        	Line EF=new Line(E,F);
	        	Triangle ABC=new Triangle(A,B,C);
	        	Triangle DEF=new Triangle(D, E, F);
	        	
	        	Angle ABCangle=new Angle(AB,BC);
	        	Angle DEFangle=new Angle(DE,EF);
	        	
	        	GeoRelation relation1=new GeoRelation(DEFangle, ABCangle, Relation.EQUALS);
	        	GeoRelation relation2=new GeoRelation(AB, DE, Relation.EQUALS);
	        	GeoRelation relation3=new GeoRelation(BC, EF, Relation.EQUALS);
	        	
	        	
	        	kSession.insert(relation1);
	        	kSession.insert(relation2);
	        	kSession.insert(relation3);
	        	
	        	kSession.insert(ABC);
	        	kSession.insert(DEF);
	        	kSession.fireAllRules();
	        	
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}
}
