package com.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.Angle;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;

public class ParrellelLineTest {

	public static void main(String args[]){
	      try {
	        	
	        	
	  		Point A = new Point('A');
			Point B = new Point('B');
			Point C = new Point('C');
			Point D = new Point('D');
			Point E = new Point('E');
			
			Line AB = new Line(A, B);
			Line BC = new Line(B, C);
			Line CD = new Line(C, D);
			Line CE = new Line(C, E);
			Line BA = new Line(B, A);
			
			Angle ABC = new Angle(AB, BC);
			Angle BCD = new Angle(BC, CD);
			Angle DCE = new Angle(CD, CE);
			Angle test = new Angle(BA, BC);

			GeoRelation ABparrCD = new GeoRelation(AB, CD, Relation.PARALLEL_LINES);
	        	
	        	
	        	
	            // load up the knowledge base
		        KieServices ks = KieServices.Factory.get();
	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	        	KieSession kSession = kContainer.newKieSession("ksession-rules");

	            // go !
	            kSession.insert(ABparrCD);
	            kSession.insert(ABC);
	            kSession.insert(BCD);
	            kSession.fireAllRules();
	        	
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}
}
