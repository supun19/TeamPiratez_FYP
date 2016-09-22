package com.markingschema;

import javax.xml.bind.annotation.XmlElement;

public class Step {
	Expression expression;
	Reason reason;
	@XmlElement
	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	@XmlElement
	public Reason getReason() {
		return reason;
	}
	public void setReason(Reason reason) {
		this.reason = reason;
	}
	
}
