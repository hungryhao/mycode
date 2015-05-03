package com.hungry.singleton;

//可用于多线程，但加锁耗时，不管instance是否为null都加锁
public class Singleton2 {
	private Singleton2() {

	}

	private final static Object syncObj = new Object();
	private static Singleton2 instance = null;

	public static Singleton2 getInstance() {
		synchronized (syncObj) {
			if (instance == null) {
				instance = new Singleton2();
			}
		}
		return instance;
	}

}
