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
import com.sample.RelationType;
import com.sample.Triangle;

public class Theorem1 {
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
	        	
	        	
	        	ExpressionRelation relation1=new ExpressionRelation(RelationType.EXPRESSION_RELATION);
	        	Triangle ABC=new Triangle(A,B,C);
	        	
	        	Line AB=new Line(A,B);
	        	Line BC=new Line(B,C);
	        	Line BD=new Line(B,D);
	        	Line AC=new Line(A,C);
	        	
	        	Angle ABD=new Angle(AB,BD);
	        	Angle CBD=new Angle(BD,BC);
	        	Angle val=new Angle(180);
	        	GeoRelation AConB =new GeoRelation(AC, B, Relation.ON_THE_LINE);
	        	
	        	relation1.addItem(ABD);
	        	relation1.addOperation(Relation.PLUS);
	        	relation1.addItem(CBD);
	        	relation1.addOperation(Relation.EQUALS);
	        	relation1.addItem(val);
	        	//Test 1
	        	
	        	//kSession.insert(relation1);
	        	kSession.insert(BD);
	        	kSession.insert(AConB);
	        	kSession.insert(ABD);
	        	kSession.insert(CBD);
	        	//Test2
	        	/*Line DF=new Line(D,F);
	        	Line ED=new Line(E,D);
	        	Angle EDF=new Angle(DF,ED);
	        	GeoRelation relation4 =new GeoRelation(ABCangle,EDF,Relation.EQUALS);
	        	kSession.insert(relation4);
	        	kSession.insert(relation2);
	        	kSession.insert(relation3);
	        	
	        	kSession.insert(ABC);
	        	kSession.insert(DEF);*/
	        	kSession.fireAllRules();
	        	QueryResults results = kSession.getQueryResults( "getObjectsOfClassA" ); 
	        	for ( QueryResultsRow row : results ) {
	        		ExpressionRelation classA = ( ExpressionRelation ) row.get( "$result" ); //you can retrieve all the bounded variables here
	        	    //do whatever you want with classA
	        		System.out.println(classA.items.get(2).value);
	        	}
	        	
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}
}
