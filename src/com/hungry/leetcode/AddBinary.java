package com.hungry.leetcode;

public class AddBinary {
	
	public String addBinary(String a, String b) {
		String sum = "";
		int carryOver = 0;
		for(int i=a.length()-1, j=b.length()-1; i>=0 || j>=0; i--, j--) {
			int aInt = i<0?0:Integer.parseInt(a.charAt(i)+"");
			int bInt = j<0?0:Integer.parseInt(b.charAt(j)+"");
			sum = (aInt^bInt^carryOver) + sum;
			carryOver = (aInt+bInt+carryOver)>1?1:0;
		}
		if(carryOver==1) {
			sum = "1" + sum;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		String a = "11010";
		String b = "11011";
		System.out.println(ab.addBinary(a, b));
	}
}
