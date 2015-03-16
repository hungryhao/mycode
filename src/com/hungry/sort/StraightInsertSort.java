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

	public void insertSort2(int[] num) {
		int j;
		for (int i = 1; i < num.length; i++) {
			int k = num[i];
			for (j = i; j > 0 && k < num[j - 1]; j--) {
				num[j] = num[j - 1];
			}
			num[j] = k;
		}
	}

	public static void main(String[] args) {
		StraightInsertSort sis = new StraightInsertSort();
		int[] num = { 2, 5, 6, 3, 7, 8 };
		sis.insertSort2(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
