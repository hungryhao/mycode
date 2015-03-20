package com.hungry.sort;

public class QuickSort {

	/**
	 * @param args
	 */
	
	

	private int partition(int[] num, int low, int high) {
		int pivotKey = num[low];
		while (low < high) {
			while (low < high && num[high] >= pivotKey) {
				high--;
			}
			int temp = num[low];
			num[low] = num[high];
			num[high] = temp;
			while (low < high && num[low] <= pivotKey) {
				low++;
			}
			temp = num[low];
			num[low] = num[high];
			num[high] = temp;
		}
		return low;
	}

	public void quickSort(int[] num, int low, int high) {
		if (low < high) {
			int pivot = partition(num, low, high);
			quickSort(num, low, pivot - 1);
			quickSort(num, pivot + 1, high);
		}
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int num[] = { 1, 7, 9, 3, 4, 8 };
		int low = 0;
		int high = num.length - 1;
		qs.quickSort(num, low, high);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
