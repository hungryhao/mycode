package com.hungry.others;

public class NumberOfBinaryOne {
	
	public int numberOfOne(int n) {
		int count = 0;
		
		while(n!=0) {
			++count;
			n &= (n-1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		NumberOfBinaryOne nb = new NumberOfBinaryOne();
		int n = 0;
		System.out.println(nb.numberOfOne(n));
	}

}
