package com.markingschema;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.sun.org.apache.xerces.internal.impl.xs.SubstitutionGroupHandler;

public class MarkSet {
	int id;
	 
	private List<Step> step;
	@XmlAttribute 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement  
	public List<Step> getStep() {
		return step;
	}

	public void setStep(List<Step> step) {
		this.step = step;
	}
	
	
	
}
