package com.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.Angle;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;

public class Theorem_01_Test {
	public static final void main(String[] args) {
        try {
        	
        	Point A = new Point('A');
        	Point B = new Point('B');
        	Point C = new Point('C');        	
        	Point D = new Point('D');
  
        	Line AB = new Line(A, B);
        	Line CD = new Line(C, D);
        	Line AC = new Line(A,C);
        	Line BC = new Line(B,C);
        	
        	Angle ACD = new Angle(AC, CD);
        	Angle BCD = new Angle(CD, BC);
        	
        	GeoRelation on_the_line = new GeoRelation(AB, C, Relation.ON_THE_LINE);
  
        	// load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            kSession.insert(on_the_line);
            kSession.insert(CD);
            kSession.insert(ACD);
            kSession.insert(BCD);
            
            kSession.fireAllRules();
        	
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
