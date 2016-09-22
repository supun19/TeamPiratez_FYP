package com.reason;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.sample.Reason;

public class ReasonDictionary {
	 // create an enum
	private Hashtable<Enum,ArrayList<String>> htable;
	ReasonDictionary() {
		   // create hash table 
		   htable = new Hashtable<Enum,ArrayList<String>>();
		   dummyData();
	} 
	public void addTokenListToDictionary(Reason key,ArrayList<String> tokenz){
		 this.htable.put( key,tokenz);
	}
	public void addTokenToDictionary(Reason key,String token){
		ArrayList<String> tokenz=(ArrayList<String>) htable.get(key);
		tokenz.add(token);
		addTokenListToDictionary(key, tokenz);
	}
	public ArrayList<String> getTokenz(Reason key){
		return (ArrayList<String>) htable.get(key);
	} 
	public void dummyData(){
		 ArrayList<String> tokenz=new ArrayList<String>();
	      tokenz.add("ඒකෝ");
	      tokenz.add("ඒකාන්තර");
	      tokenz.add("ඒකාන්තර කෝණ");
	      tokenz.add("ඒ");
	      addTokenListToDictionary(Reason.ALTERNATE_ANGLES, tokenz);
	}
}
