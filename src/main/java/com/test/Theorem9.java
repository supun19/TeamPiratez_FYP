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

public class Theorem9 {
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
	        	
	        	Triangle ABC=new Triangle(A,B,C);
	        	
	        	Line AD=new Line(A,D);
	        	
	        	GeoRelation ADonC = new GeoRelation(AD,C,Relation.ON_THE_LINE); 
	        	Line BC=new Line(B,C);
	        	Line CD=new Line(C,D);
	        	Angle BCD=new Angle(BC,CD);
	        	kSession.insert(ABC);
	        	kSession.insert(ADonC);
	        	kSession.insert(BCD);
	        
	        	kSession.fireAllRules();
	        	
	        	
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}
}
