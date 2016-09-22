package com.markingschema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.sun.tracing.dtrace.Attributes;

public class Question {
	private List<SubQuestion> subQuestion;
	
	private String totalMarks;
	
	private String id;
	
	public Question() {
		super();
		subQuestion=new ArrayList<SubQuestion>();
	}

	@XmlAttribute 
	public String getTotalMarks() {
		return totalMarks;
	}
	
	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	@XmlAttribute 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement  
	public List<SubQuestion> getSubQuestion() {
		return subQuestion;
	}

	public void setSubQuestion(List<SubQuestion> subquestion) {
		this.subQuestion = subquestion;
	}
	
	
}
