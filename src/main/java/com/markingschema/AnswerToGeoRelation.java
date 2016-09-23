package com.markingschema;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.io.AnswerGetter;
import com.sample.Angle;
import com.sample.GeoItem;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;

public class AnswerToGeoRelation {
	public static void main(String arg[]){
		AnswerToGeoRelation answerToGeoRelation=new AnswerToGeoRelation();
		
		GeoRelation a=answerToGeoRelation.getRelation("{line}AB//{line}CD");
		System.out.println(a.firstItem.getName()+""+a.secondItem.getName());
	}
	public GeoRelation getRelation(String step){

		String reason = "";
        try {
            byte[] utf8Bytes = step.getBytes("UTF-8");

            reason = new String(utf8Bytes, "UTF-8");
            step = new String(utf8Bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        
		GeoRelation relation = null;
		String[] spilteStep = step.split("=");
		String left;
		String right;
		GeoItem item1;
		GeoItem item2;
		//ABC = BCD (ඒකාන්තර කෝණ)
		if (spilteStep.length > 1) {
			
			left = RemoveBracket(spilteStep[0]);
			right = RemoveBracket(spilteStep[1]);
			item1=choiceGeoItem(left);
			item2=choiceGeoItem(right);
			relation = new GeoRelation(item1, item2, Relation.EQUALS);
		}

		spilteStep = step.split("//");
		if (spilteStep.length > 1) {
			left = RemoveBracket(spilteStep[0]);
			right = RemoveBracket(spilteStep[1]);
			
			item1=choiceGeoItem(left);
			item2=choiceGeoItem(right);
			relation = new GeoRelation(item1, item2, Relation.PARALLEL_LINES);
		}

		return relation;
		
	}
	private String RemoveBracket(String step){
		
		String reason = "";
        try {
            byte[] utf8Bytes = step.getBytes("UTF-8");

            reason = new String(utf8Bytes, "UTF-8");
            step = new String(utf8Bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		Pattern unicodeOutliers = Pattern.compile("[\\u007b || \\u007d]",
                Pattern.UNICODE_CASE | Pattern.CANON_EQ
                        | Pattern.CASE_INSENSITIVE);
        Matcher unicodeOutlierMatcher = unicodeOutliers.matcher(reason);
        reason = unicodeOutlierMatcher.replaceAll(" ");
        reason = reason.trim();
       
        return reason;
	}
	private GeoItem choiceGeoItem(String step){
		GeoItem item = null;
		String[] substep=step.split(" ");
		if(substep[0].equals("line")){
			
			item=lineItem(substep[1].toCharArray());
			System.out.println(item.name);
		}
		if(substep[0].equals("angle")){
			item=angleItem(substep[1].toCharArray());
		}
		return item;
	}
	
	/*private GeoItem choichGeoItem(char[] part) {
		GeoItem item = null;
		if (isItem(part)) {
			if (part.length == 2) {
				item = lineItem(part);
				
			}
			if (part.length == 3) {
				item = angleItem(part);
				
			}
		}

		return item;
	}*/

	/*private boolean isItem(char[] part) {
		for (int i = 0; i < part.length; i++) {
			if (part[i] >= '0' && part[i] <= '9') {

				return false;
			}
		}
		return true;

	}*/

	public Line lineItem(char[] name) {

		return new Line(new Point(name[0]), new Point(name[1]));
	}

	public Angle angleItem(char[] name) {
		
		//System.out.println("char array "+name[0]+name[1]+name[2]);
		Point A=new Point(name[0]);
		Point B=new Point(name[1]);
		Point C=new Point(name[2]);
		Line AB=new Line(A, B);
		Line BC=new Line(B, C);
		Angle a=new Angle(AB,BC);
		
		return a;
	}
}
