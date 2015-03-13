package com.hungry.sort;

public class QuickSort {

	/**
	 * @param args
	 */
	
	private int partition(int[] num, int low, int high) {
		int privotKey = num[low];
		while(low<high) {
			while(low<high && num[high]>=privotKey) {
				high--;
			}
			int temp = num[low];
			num[low] = num[high];
			num[high] = temp;
			while(low<high && num[low]<=privotKey) {
				low++;
			}
			temp = num[low];
			num[low] = num[high];
			num[high] = temp;
		}
		return low;
	}
	
	public void quickSort(int[] num, int low, int high) {
		if(low<high) {
			int privot = partition(num, low, high);
			quickSort(num, low, privot-1);
			quickSort(num, privot+1, high);
		}
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int num[] = {2,5,9,3,4};
		int low = 0;
		int high = num.length-1;
		qs.quickSort(num, low, high);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
