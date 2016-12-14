package com.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import com.sample.Angle;
import com.sample.ExpressionRelation;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;
import com.sample.Triangle;

public class Theorem10 {
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
	        	
	        	
	        	kSession.insert(ABC);
	        	
	        
	        	kSession.fireAllRules();
	        	QueryResults results = kSession.getQueryResults( "getObjectsOfClassA" ); 
	        	for ( QueryResultsRow row : results ) {
	        		ExpressionRelation classA = ( ExpressionRelation ) row.get( "$result" ); //you can retrieve all the bounded variables here
	        	    //do whatever you want with classA
	        		for(int i=0;i<classA.size;i++){
	        			System.out.println(classA.items.get(i).value);
	        		}
	        		
	        	}
	        	
	        	
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}
}
