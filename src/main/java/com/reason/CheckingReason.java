package com.reason;

import java.util.ArrayList;

import com.sample.GeoRelation;
import com.sample.Reason;

public class CheckingReason {
	ReasonDictionary dictionary;
	public CheckingReason(){
		dictionary=new ReasonDictionary();
	}
	public boolean isReasonValid(String studentReason,Reason generateReason){
		boolean reason=false;
		ArrayList<String> tokenz=dictionary.getTokenz(generateReason);
		
		for (String token : tokenz) {
			reason=isStudentReasonCompaireWithTokenz(studentReason, token);
			if(reason==true){
				break;
			}
			
		}
		return reason;
	}
	
	public boolean isStudentReasonCompaireWithTokenz(String studentReason,String token){
		if(studentReason.equals(token)){
			return true;
		}
		return false;
	}
	
}
