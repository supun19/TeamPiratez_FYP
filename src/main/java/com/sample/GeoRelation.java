package com.sample;

import java.util.ArrayList;

public class GeoRelation {
	public GeoItem firstItem;
	public GeoItem secondItem;
	public Relation relation;
	public ArrayList<Reason> reasons;
	public int markforrelation;
	public int markforreason;
	public String studentReason;
	
	public GeoRelation(GeoItem first, GeoItem second, Relation relation){
		this.firstItem = first;
		this.secondItem = second;
		this.relation = relation;
		this.reasons = new ArrayList<>();
	}
	
	public GeoRelation(GeoItem first, GeoItem second, Relation relation,Reason reason){
		this.firstItem = first; 
		this.secondItem = second;
		this.relation = relation;
		this.reasons = new ArrayList<>();
		this.reasons.add(reason);
	}
	
	public GeoRelation(GeoItem first, GeoItem second, Relation relation,ArrayList<Reason> reasons){
		this.firstItem = first;
		this.secondItem = second;
		this.relation = relation;
		this.reasons = reasons;
	}
	
	public String getName(){
		
		return firstItem.getName() + " " + relation +" "+ secondItem.getName();
	}
	
	public void setReason(Reason reason){
		this.reasons.add(reason);
	}

	public String getStudentReason() {
		return studentReason;
	}

	public void setStudentReason(String studentReason) {
		this.studentReason = studentReason;
	}

	public int getMarkforrelation() {
		return markforrelation;
	}

	public void setMarkforrelation(int markrelation) {
		this.markforrelation = markrelation;
	}

	public int getMarkforreason() {
		return markforreason;
	}

	public void setMarkforreason(int markreason) {
		this.markforreason = markreason;
	}
	
	
}
