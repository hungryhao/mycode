package com.hungry.sort;

public class ShellInsertSort {
	
	public void shellInsertSort(int[] num, int distance) {
		int len = num.length;
		for(int i=distance; i<len; i++) {
			int j = i-distance;
			int  k = num[i];
			while(j>=0&&k<num[j]) {
				num[j+distance] = num[j];
				j -= distance;
			}
			num[j+distance] = k;
		}
	}

	public static void main(String[] args) {
		ShellInsertSort sis = new ShellInsertSort();
		int num[] = {2,5,9,3,4};
		int distance = num.length/2;
		while(distance>0) {
			sis.shellInsertSort(num, distance);
			distance = distance/2;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
