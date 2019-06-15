package com.ramanjit.io.examples;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SingleTonSerialization implements Serializable {
	private static SingleTonSerialization mySingletonVar = null; // No one can
																	// access

	public synchronized static SingleTonSerialization getInstance() {
		if (mySingletonVar == null) {
			mySingletonVar = new SingleTonSerialization();
		}
		return mySingletonVar;
	}

	protected Object ReadResolve() {
		System.out.println("From read resolve method");
		return mySingletonVar;
	}

	private SingleTonSerialization() {
		System.out.println("I am singleton constructor");
	}

	public void loadUserDetail() {
		System.out.println("User Name  - Password combination");
		Map<String, String> loginDetailsMap = new HashMap<String, String>();
		loginDetailsMap.put("C001", "cT@123");
		loginDetailsMap.put("C002", "cT@124");
		loginDetailsMap.put("C003", "cT@125");
		loginDetailsMap.put("C004", "cT@126");
	}
}
