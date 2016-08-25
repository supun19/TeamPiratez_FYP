package com.test;

import java.util.ArrayList;

import com.knowledge.KnowledgeHolder;
import com.sample.Angle;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;

public class RelationExistTest {
	public static void main(String args[]){
		
		final  KnowledgeHolder inferedKnowledge;
		
		Point A = new Point('A');
		Point B = new Point('B');
		Point C = new Point('C');
		Point D = new Point('D');
		Point E = new Point('E');
		
		Line AB = new Line(A, B);
		Line BC = new Line(B, C);
		Line CD = new Line(C, D);
		Line CE = new Line(C, E);
		
		Angle ABC = new Angle(BC, AB);
		Angle test = new Angle(AB, BC);
		Angle DCE = new Angle(CD, CE);
		
		GeoRelation relData = new GeoRelation(ABC, DCE, Relation.EQUALS);
		GeoRelation reltest = new GeoRelation(DCE, test, Relation.EQUALS);
		
		GeoRelation relParrData = new GeoRelation(AB, CD, Relation.PARALLEL_LINES);
		
		ArrayList<GeoRelation> initRelations = new ArrayList<GeoRelation>();
		
		initRelations.add(relData);

		initRelations.add(relParrData);

		inferedKnowledge = new KnowledgeHolder(initRelations);
		
		System.out.println(ABC.sameItem(test));
		System.out.println(inferedKnowledge.relationExists(reltest));
		
		
	}

}
