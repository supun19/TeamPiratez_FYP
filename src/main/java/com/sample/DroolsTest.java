package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
        	
        	
        	
        	Point point1 = new Point('A');
        	Point point2 = new Point('D');
        	Point point3 = new Point('B');        	
        	Point point4 = new Point('C');
        	Point pointO = new Point('M');
  
        	Line lineAB = new Line(point1, point2);
        	Line lineCD = new Line(point3, point4);
        	Line lineBC = new Line(point2, point3);
        	Line lineAD = new Line(point1, point4);
        	
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            //kSession.insert(message);
            //kSession.fireAllRules();
        	
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
