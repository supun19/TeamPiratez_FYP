package com.nlp;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckingReason {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String Text = "එ කෝ සමාන වේ";
		Reason reason=Reason.ALTERNATIVE_ANGLE;
		
		CheckingReason test=new CheckingReason();
		EnumDictionary enumDictionary=new EnumDictionary();
		Dictionary dictionary = new Dictionary();
		SinhalaMapper mapper = new SinhalaMapper();
		test.fillEnumDic(enumDictionary);
		test.fillDictionary(dictionary);
		System.out.println( test.isReasonValide(reason, Text, dictionary, enumDictionary, mapper));
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
