package com.knowledge;

import java.util.ArrayList;
import java.util.Iterator;

import com.sample.GeoItem;
import com.sample.GeoRelation;

public class KnowledgeHolder {

	private ArrayList<GeoRelation> knowledge = new ArrayList<GeoRelation>();

	public KnowledgeHolder(ArrayList<GeoRelation> knowledge){

		this.knowledge = knowledge;

	}

	public KnowledgeHolder(){


	}

	
	//to get full knowledge up to now
	public ArrayList<GeoRelation> getFullKnowledge(){

		return knowledge;

	}
	
	public boolean insertGeoRelation(GeoRelation relation){
		
		if(relationExists(relation))
		
			return false;

		else{
			
			knowledge.add(relation);
			
			return true;
		}



	}
	
	public boolean relationExists(GeoRelation relation){
		
		for (Iterator<GeoRelation> iterator = knowledge.iterator(); iterator.hasNext();) {
			

			GeoRelation geoRelation = (GeoRelation) iterator.next();

			//System.out.println(geoRelation.getName());

			
			//if two relation types are not matching
			if( geoRelation.relation != relation.relation)
				continue;
			
			//if two first items are miss match
			if( geoRelation.firstItem.type != relation.firstItem.type)
				continue;

			//if two second items are miss match
			if( geoRelation.secondItem.type != relation.secondItem.type)
				continue;

			//if relation1 item1 == relation2.item1
			// and relation1 item2 == relation2.item2
			if(( geoItemsAreSame(geoRelation.firstItem, relation.firstItem) )
					&& ( geoItemsAreSame(geoRelation.secondItem, relation.secondItem) ))
				return true;

			//if relation1 item2 == relation2.item1
			// and relation1 item1 == relation2.item2
			if(( geoItemsAreSame(geoRelation.secondItem, relation.firstItem) )
					&& ( geoItemsAreSame(geoRelation.firstItem, relation.secondItem) ))
				return true;

		}
		
		return false;
	}
	
	public boolean geoItemsAreSame(GeoItem item1, GeoItem item2){
			
		//System.out.println("items" + item1 + item2);
		return item1.sameItem(item2);

	}
	
	public void printdata(){
		
		System.out.println("--------------items in knowledge Holder-------------");
		for (Iterator<GeoRelation> iterator = knowledge.iterator(); iterator.hasNext();) {
			

			GeoRelation geoRelation = (GeoRelation) iterator.next();
			
			System.out.println(geoRelation.getName());

		}		
	}

	
}



