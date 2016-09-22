package com.markingschema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class AnswerScript {
	
	
	private String type;
	private String sectionid;
	private List<Question> question;
	
	public AnswerScript() {
		super();
		question=new ArrayList<Question>();
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	public String getSectionid() {
		return sectionid;
	}
	@XmlElement
	public void setSectionid(String sectionid) {
		this.sectionid = sectionid;
	}
	public List<Question> getQuestion() {
		return question;
	}
	@XmlElement
	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	
}
