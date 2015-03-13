package com.hungry.sort;

public class StraightInsertSort {

	public void insertSort(int[] num) {
		int len = num.length;
		for (int i = 0; i < len; i++) {
			int j = i - 1;
			int k = num[i];
			while (j >= 0 && k < num[j]) {
				num[j + 1] = num[j];
				j--;
			}
			num[j + 1] = k;
		}
	}

	public static void main(String[] args) {
		StraightInsertSort sis = new StraightInsertSort();
		int[] num = { 2, 5, 6, 3, 7, 8 };
		sis.insertSort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
