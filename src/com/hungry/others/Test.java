package com.hungry.others;


public class Test {
	
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		operate(a, b);
		System.out.println(a+","+b);
		int[] x = new int[26];
		int[] y;
		System.out.println(x[25]);
	}
	
	private static void operate(StringBuffer x, StringBuffer y) {
		x.append(y);
		y = x;
		
	}

}
