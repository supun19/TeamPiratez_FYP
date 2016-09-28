package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kie.api.runtime.KieSession;

import com.sample.Angle;
import com.sample.GeoItem;
import com.sample.GeoRelation;
import com.sample.Line;
import com.sample.Point;
import com.sample.Relation;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class AnswerGetter {

	public ArrayList<GeoRelation> readFile(String filename) throws IOException {

		ArrayList<GeoRelation> relations = new ArrayList<GeoRelation>();
		FileReader fileReader = new FileReader(new File(filename));

		BufferedReader br = new BufferedReader(new InputStreamReader(
			    new FileInputStream(new File(filename)), "UTF-8"));
		//BufferedReader br = new BufferedReader(fileReader);

		String line = null;
		// if no more lines the readLine() returns null
		while ((line = br.readLine()) != null) {
			// reading lines until the end of the file
			GeoRelation parallel = splitScript(line);
			relations.add(parallel);
		}
		return relations;

	}
	

	public GeoRelation splitScript(String step) {
		
		
		String reason = "";
        try {
            byte[] utf8Bytes = step.getBytes("UTF-8");

            reason = new String(utf8Bytes, "UTF-8");
            step = new String(utf8Bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Pattern unicodeOutliers = Pattern.compile("[^\\u0D80-\\u0DFF]",
                Pattern.UNICODE_CASE | Pattern.CANON_EQ
                        | Pattern.CASE_INSENSITIVE);
        Matcher unicodeOutlierMatcher = unicodeOutliers.matcher(reason);
        reason = unicodeOutlierMatcher.replaceAll(" ");
        reason = reason.trim();
        
        unicodeOutliers = Pattern.compile("[\\u0D80-\\u0DFF || \\( || \\) || \\uFEFF]",
                Pattern.UNICODE_CASE | Pattern.CANON_EQ
                        | Pattern.CASE_INSENSITIVE);
        unicodeOutlierMatcher = unicodeOutliers.matcher(step);
        step = unicodeOutlierMatcher.replaceAll(" ");
        step = step.trim();
        
		GeoRelation relation = null;
		String[] spilteStep1 = step.split("=");
		char[] part1;
		char[] part2;
		GeoItem item1;
		GeoItem item2;
		//ABC = BCD (ඒකාන්තර කෝණ)
		if (spilteStep1.length > 1) {
			part1 = spilteStep1[0].replaceAll("\\s", "").toCharArray();
			part2 = spilteStep1[1].replaceAll("\\s", "").toCharArray();
			item1 = choichGeoItem(part1);
			item2 = choichGeoItem(part2);
			
			relation = new GeoRelation(item1, item2, Relation.EQUALS);
		}

		spilteStep1 = step.split("//");
		if (spilteStep1.length > 1) {
			part1 = spilteStep1[0].replaceAll("\\s", "").toCharArray();
			part2 = spilteStep1[1].replaceAll("\\s", "").toCharArray();
			item1 = choichGeoItem(part1);
			item2 = choichGeoItem(part2);
			relation = new GeoRelation(item1, item2, Relation.PARALLEL_LINES);
		}
		relation.setStudentReason(reason);
		return relation;
	}

	private GeoItem choichGeoItem(char[] part) {
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
	}

	private boolean isItem(char[] part) {
		for (int i = 0; i < part.length; i++) {
			if (part[i] >= '0' && part[i] <= '9') {

				return false;
			}
		}
		return true;

	}

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
