package com.markingschema;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.sun.org.apache.xerces.internal.impl.xs.SubstitutionGroupHandler;

public class MarkSet {
	int id;
	StepGroup stepGroup; 
	@XmlAttribute 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public StepGroup getStepGroup() {
		return stepGroup;
	}

	public void setStepGroup(StepGroup stepGroup) {
		this.stepGroup = stepGroup;
	}
	
}
