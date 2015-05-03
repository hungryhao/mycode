package com.hungry.singleton;

//推荐。只在get时才创建实例。使用静态内部类，且私有，其他人无法使用。
public class Singleton5 {

	private Singleton5() {

	}

	private static class Nested {
		private static final Singleton5 instance = new Singleton5();
	}

	public static Singleton5 getInstance() {
		return Nested.instance;
	}

}
