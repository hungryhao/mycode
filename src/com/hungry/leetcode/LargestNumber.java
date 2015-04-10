package com.hungry.leetcode;

public class LargestNumber {
		
	public String largestNumber(int[] num) {
		String[] str = new String[num.length];
		for(int i=0; i<num.length; i++) {
			str[i] = num[i] + "";
		}
		for(int i=0; i<str.length; i++) {
			int j = i-1;
			String k = str[i];
			while(j>=0 && compareMethod(k, str[j])>0) {
				str[j+1] = str[j];
				j--;
			}
			str[j+1] = k;
		}
		if(str[0].equals("0")) {
			return "0";
		}
		String res = "";
		for(int i=0; i<str.length; i++) {
			res += str[i];
		}
		return res;
	}
	
	public String largestNumber2(int[] num) {
		String[] str = new String[num.length];
		for(int i=0; i<num.length; i++) {
			str[i] = num[i] + "";
		}
		int dk = num.length/2;
		while(dk>0) {
			shellSort(str, dk);
			dk /= 2;
		}
		if(str[0].equals("0")) {
			return "0";
		}
		String res = "";
		for(int i=0; i<str.length; i++) {
			res += str[i];
		}
		return res;
	}
	
	private void shellSort(String[] str, int dk) {
		for(int i=dk; i<str.length; i++) {
			int j = i-dk;
			String k = str[i];
			while(j>=0 && compareMethod(k, str[j])>0) {
				str[j+dk] = str[j];
				j -= dk;
			}
			str[j+dk] = k;
		}
	}
	
	private int compareMethod(String s1, String s2) {
		String str1 = s1 + s2;
		String str2 = s2 + s1;
		return str1.compareTo(str2);
	}
	
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] num = {3, 30, 34, 5, 9};
		System.out.println(ln.largestNumber2(num));
	}

	

}
