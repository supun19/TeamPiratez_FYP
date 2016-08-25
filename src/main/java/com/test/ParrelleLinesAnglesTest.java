package com.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.Angle;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;

public class ParrelleLinesAnglesTest {
	
	public static final void main(String[] args) {
        try {
        	
        	
        	
        	Point A = new Point('A');
        	Point B = new Point('B');
        	Point C = new Point('C');        	
        	Point D = new Point('D');
  
        	Line AB = new Line(A, B);
        	Line CD = new Line(C, D);
        	Line BC = new Line(B, C);
        	Line AD = new Line(A, D);
        	
        	Angle ABC = new Angle(BC, AB);
        	Angle BCD = new Angle(BC, CD);
        	
        	GeoRelation parrLines = new GeoRelation(AB, CD, Relation.PARALLEL_LINES);
  
        	// load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            kSession.insert(ABC);
            kSession.insert(BCD);
            
            kSession.insert(parrLines);
            
            
            kSession.fireAllRules();
        	
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
