package com.hungry.leetcode;

public class TitleToNumber {
	public int titleToNumber(String s) {
		int num = 0;
		int len = s.length();
		for(int i=0; i<len; i++) {
			int x = (int)(s.charAt(len-i-1)) - 64;
			num = (int)(num + (x * Math.pow(26, i)));
		}
		
		return num;
	}
	
	public int titleToNumber2(String s) {
		int num = 0;
		char[] sc = s.toCharArray();
		int len = sc.length;
		for(int i=len-1; i>=0; i--) {
			int x = (int)(sc[i]) - 64;
			num = (int)(num + (x * Math.pow(26, len-i-1)));
		}
		return num;
	}
	
	public static void main(String[] args) {
		String s = "ABA";
		System.out.println(String.valueOf(s));
		TitleToNumber t = new TitleToNumber();
		System.out.println(t.titleToNumber2(s));
	}

}
