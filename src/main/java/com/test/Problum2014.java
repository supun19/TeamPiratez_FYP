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

public class Problum2014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		        	
		        	
		        	
		        	kSession.fireAllRules();
		        	
		        } catch (Throwable t) {
		            t.printStackTrace();
		        }
		}
	

}
