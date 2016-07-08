package com.sample;

public class GeoRelation {
	public GeoItem firstItem;
	public GeoItem secondItem;
	public Relation relation;
	
	public GeoRelation(GeoItem first, GeoItem second, Relation relation){
		this.firstItem = first;
		this.secondItem = second;
		this.relation = relation;
	}
}
