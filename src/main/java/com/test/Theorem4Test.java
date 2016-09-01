package com.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.Angle;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;

public class Theorem4Test {
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
	        	
	        	Line AB =new Line(A,B);
	        	Line CD =new Line(C,D);
	        	Line EF=new Line(E, F);
	        	Line AE=new Line(A,E);
	        	Line DF=new Line(D, F);
	        	Line EG=new Line(E,G);
	        	Line CE=new Line(C, E);
	        	Line CF=new Line(C, F);
	        	Line FG=new Line(F, G);
	        	Angle AEF=new Angle(EF, AE);
	        	Angle EFD=new Angle(EF, DF);
	        	
	        	Angle CFG=new Angle(FG,CF);
	        	
	        	Angle CFE=new Angle(CF,EF);
	        	GeoRelation online1=new GeoRelation(AB, E, Relation.ON_THE_LINE);
	        	GeoRelation online2=new GeoRelation(CD, F, Relation.ON_THE_LINE);
	        	GeoRelation online3=new GeoRelation(EG, F, Relation.ON_THE_LINE);
	        	
	        	GeoRelation twoangle=new GeoRelation(AEF, EFD, Relation.EQUALS);
	        	GeoRelation correspondingAngle=new GeoRelation(AEF, CFG, Relation.EQUALS);
	        	GeoRelation opositangle =new GeoRelation(AEF, CFE, Relation.EQUALS180);
	        	kSession.insert(online1);
	        	kSession.insert(online2);
	        	//kSession.insert(twoangle);
	        	kSession.insert(EF);
	        	kSession.insert(online3);
	        	//kSession.insert(correspondingAngle);
	        	kSession.insert(opositangle);
	        	kSession.fireAllRules();
	        	
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}
}
