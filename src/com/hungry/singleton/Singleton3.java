package com.hungry.singleton;

//只有instance为null时才加锁，提高效率。两次验证null，若已被锁，则等待，等待完了还要验证是否null
public class Singleton3 {
	private Singleton3() {

	}

	private static final Object syncObj = new Object();
	private static Singleton3 instance = null;

	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized (syncObj) {
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}

}
