package com.hungry.leetcode;

public class ReverseInteger {

	public int reverse(int x) {
		long res = 0;
		int remainder = 0;
		while (x != 0) {
			remainder = x % 10;
			x = x / 10;
			res = res * 10 + remainder;
			if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE) {
				return 0;
			}
		}
		/*if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE) {
			return 0;
		}*/
		return (int) res;
	}

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		int x = -231;
		System.out.println(ri.reverse(x));
		System.out.println((" ").isEmpty());
	}

}
