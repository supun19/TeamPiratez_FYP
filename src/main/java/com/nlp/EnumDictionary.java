package com.nlp;

import java.util.ArrayList;
import java.util.HashMap;

public class EnumDictionary {
	private HashMap<Enum,String> dictionary;
	public EnumDictionary(){
		dictionary = new  HashMap<Enum,String>();
	}
	public void putTokensToDictionary(Enum key,String tokens){
		this.dictionary.put(key, tokens);
		
	}
	public String getTextFromEnum(Enum key){
		return this.dictionary.get(key);
	}
	
}
