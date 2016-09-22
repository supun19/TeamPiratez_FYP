package com.markingschema;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class SubQuestion {
	private int id;
	private int totalMarks;
	private boolean isProof;
	private MarkSet markSet;
	@XmlAttribute 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlAttribute 
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public boolean getIsProof() {
		return isProof;
	}
	public void setIsProof(boolean isProof) {
		this.isProof = isProof;
	}
	@XmlElement
	public MarkSet getMarkSet() {
		return markSet;
	}
	public void setMarkSet(MarkSet markset) {
		this.markSet = markset;
	}
	
	
	
}
