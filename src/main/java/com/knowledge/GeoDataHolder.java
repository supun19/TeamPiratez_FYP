package com.knowledge;

import java.util.ArrayList;

import com.sample.GeoItem;

public class GeoDataHolder {
	
	private ArrayList<GeoItem> knowledge = new ArrayList<GeoItem>();

	public GeoDataHolder(ArrayList<GeoItem> knowledge){

		this.knowledge = knowledge;

	}
	
	public ArrayList<GeoItem> getAllGeoItemKnowledge(){
		
		return knowledge;

	}
	
	public boolean addGeoItem(GeoItem newItem){
		
		knowledge.add(newItem);
		
		return true;
	}
	
	

}
