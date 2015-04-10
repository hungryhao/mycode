package com.hungry.leetcode;

public class HammingWeight {

	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			int temp = n & 1;//取出最后一位
			if (temp == 1) {
				count++;
			}
			n >>>= 1;//无符号右移，前补0
		}
		return count;
	}
	
	//错误
	public int hammingWeight2(int n) {
		int count = 0;
		while (n != 0) {
			int temp = n % 2;
			if (temp == 1) {
				count++;
			}
			n /= 2;
		}
		return count;
	}
	
	//you need to treat n as an unsigned value
	public int hammingWeight3(int n) {
		int count = 0;
		String str = Integer.toBinaryString(n);
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='1') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		HammingWeight hw = new HammingWeight();
		int n = 21474;
		long s = Long.parseLong("2147483648");
		System.out.println(s);
		System.out.println(hw.hammingWeight(n));
	}

}
