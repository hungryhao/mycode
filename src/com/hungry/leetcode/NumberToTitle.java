package com.hungry.leetcode;

public class NumberToTitle {

	public String numberToTitle(int n) {
		String title = "";
		while (n > 0) {
			title = (char) ('A' + (n - 1) % 26) + title;
			n = (n - 1) / 26;
		}
		return title;
	}

	public static void main(String[] args) {
		int num = 26 * 26;
		NumberToTitle ntt = new NumberToTitle();
		System.out.println(ntt.numberToTitle(num));
	}

}
