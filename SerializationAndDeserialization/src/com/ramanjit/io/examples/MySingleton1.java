package com.ramanjit.io.examples;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MySingleton1 implements Serializable {
	private static MySingleton1 mySingletonVar = null; // No one can access
	private Map<String, String> loginDetailsMap;

	public synchronized static MySingleton1 getInstance() {
		if (mySingletonVar == null) {
			mySingletonVar = new MySingleton1();
			mySingletonVar.loadUserDetail();
		}
		return mySingletonVar;
	}

	protected Object ReadResolve() {
		System.out.println("From read resolve method");
		return mySingletonVar;
	}

	private MySingleton1() {
		System.out.println("I am singleton constructor");
		loginDetailsMap = new HashMap<String, String>();
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
