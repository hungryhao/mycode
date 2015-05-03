package com.hungry.singleton;
//懒汉式
//只适用于单线程，多线程时若instance为null，多个线程都会建立instance的实例
public class Singleton1 {
	private Singleton1() {

	}

	private static Singleton1 instance = null;

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}

}
