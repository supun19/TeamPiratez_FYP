package com.markingschema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class StepGroup {
	boolean order;
	StepGroup stepGroup;
	List<Step> step;
	
	public StepGroup() {
		super();
		step=new ArrayList<Step>();
	}
	

	public void setStep(List<Step> step) {
		this.step = step;
	}
	@XmlElement

	public List<Step> getStep() {
		return step;
	}


	@XmlAttribute 
	public boolean isOrder() {
		return order;
	}

	public void setOrder(boolean order) {
		this.order = order;
	}
	@XmlElement
	public StepGroup getStepGroup() {
		return stepGroup;
	}

	public void setStepGroup(StepGroup stepGroup) {
		this.stepGroup = stepGroup;
	}
	
	
	
}
