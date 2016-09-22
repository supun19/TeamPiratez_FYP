package com.markingschema;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Reason {
	String answer;
	int mark;
	@XmlElement
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String reason) {
		this.answer = reason;
	}
	@XmlAttribute
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
}
