package com.test;

import com.engine.CheckingEngine;

public class checkEngTest {
	public static void main(String args[]){
		CheckingEngine engine = new CheckingEngine();
		
		try {
			engine.check();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
