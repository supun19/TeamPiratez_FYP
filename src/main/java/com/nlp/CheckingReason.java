package com.nlp;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckingReason {
	private EnumDictionary enumDictionary;
	private Dictionary dictionary;
	private SinhalaMapper mapper;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String Text = "එ කෝ සමාන වේ";
		Reason reason=Reason.ALTERNATIVE_ANGLE;
		
		CheckingReason test=new CheckingReason();
		
		System.out.println( test.isCorrectStudentAnswer( Text,reason));
	}
	
	public CheckingReason() {
		super();
		this.enumDictionary=new EnumDictionary();
		this.dictionary=new Dictionary();
		this.mapper=new SinhalaMapper();
	}


	public boolean isCorrectStudentAnswer(String studentReation,Reason generatedReason){
		
		fillEnumDic(enumDictionary);
		fillDictionary(dictionary);
		return isReasonValide(generatedReason, studentReation, dictionary, enumDictionary, mapper);
		
	}
	public void fillDictionary(Dictionary dictionary){
		dictionary.putTokensToDictionary("ඒකාන්තර",new String[]{"ඒකාන්තර","ඒ","එ","එකාන්තර"});
		dictionary.putTokensToDictionary("ප්‍රතිමුක",new String[]{"ප්‍රතිමුක","ප්‍ර"});
		dictionary.putTokensToDictionary("කෝණ",new String[]{"කෝණ","කෝ","කෝන"});
	}
	public void fillEnumDic(EnumDictionary enumDictionary){
		enumDictionary.putTokensToDictionary(Reason.ALTERNATIVE_ANGLE, "ඒකාන්තර කෝණ");
	}
	public boolean isReasonValide(Reason reason,String Text,Dictionary dictionary,EnumDictionary enumDictionary,SinhalaMapper mapper){
			
		return mapper.compaire(Text, enumDictionary.getTextFromEnum(reason), dictionary);
	}

}
