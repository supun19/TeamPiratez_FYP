package com.test;

import com.reason.CheckingReason;
import com.sample.Reason;
import com.sun.org.apache.xerces.internal.dom.PSVIDOMImplementationImpl;

public class TestReason {
	public static void main(String args[]){
		CheckingReason checkingReason=new CheckingReason();
		
		System.out.println(checkingReason.isReasonValid("ඒකාන්තර කෝණ", Reason.ALTERNATE_ANGLES));
	}
}
