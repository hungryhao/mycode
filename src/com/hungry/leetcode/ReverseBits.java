package com.hungry.leetcode;

public class ReverseBits {
	
	public int reverseBits(int n) {
		return Integer.reverse(n);
	}
	
	public static void main(String[] args) {
		ReverseBits rb = new ReverseBits();
		int n = 5;
		System.out.println(rb.reverseBits(n));
	}

}
