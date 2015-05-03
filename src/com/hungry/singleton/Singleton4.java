package com.hungry.singleton;
//饿汉式
//推荐。利用java静态变量特性，第一次调用Singleton4时instance即被初始化。容易过早创建实例，降低内存使用效率。
public class Singleton4 {
	private Singleton4() {

	}

	private static Singleton4 instance = new Singleton4();

	public static Singleton4 getInstance() {
		return instance;
	}

}
