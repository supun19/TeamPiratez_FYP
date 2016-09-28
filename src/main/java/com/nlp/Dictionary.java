package com.nlp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Dictionary {
	private HashMap<String,ArrayList<String>> dictionary; 
	
	public Dictionary(){
		dictionary = new  HashMap<String,ArrayList<String>>();
	}
	
	public void putTokensToDictionary(String key,ArrayList<String> tokens){
		this.dictionary.put(key, tokens);
		
	}
	public void putTokensToDictionary(String key,String[] tokens){
		ArrayList<String> tokenList = new ArrayList<>(); 
		Collections.addAll(tokenList, tokens); 
		this.dictionary.put(key, tokenList);
		
	}
	public void putTokenToDictionary(String key,String token){
		ArrayList<String> tokens=this.dictionary.get(key);
		tokens.add(token);
		this.dictionary.put(key, tokens);
		
	}
	public HashMap<String,String> getSimilarTokens(String key){
		HashMap<String,String> SimilarTokens=new HashMap<String,String>();
		for (String token : dictionary.get(key)) {
			SimilarTokens.put(token, key);
		}
		
		
		return SimilarTokens;
	}
	
	
	
	
}
