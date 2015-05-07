package com.hungry.sort;

import java.util.Random;

public class QuickSort3 {

	private void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}

	private int partition(int[] data, int len, int start, int end) {
		if (data == null || len <= 0 || start < 0 || end >= len) {
			return -1;
		}

		int index = start + (int) (Math.random() * (end - start + 1));
		System.out.println("----" + index);
		swap(data, index, end);

		int small = start;
		for (index = start; index < end; ++index) {
			if (data[index] < data[end]) {
				if (small != index) {
					swap(data, index, small);
				}
				++small;
			}
		}

		swap(data, small, end);

		return small;
	}

	public void quickSort(int[] data, int len, int start, int end) {
		if (start == end) {
			return;
		}

		int index = partition(data, len, start, end);
		if (index > start) {
			quickSort(data, len, start, index - 1);
		}
		if (index < end) {
			quickSort(data, len, index + 1, end);
		}
	}

	public static void main(String[] args) {
		int[] data = { 1, 3, 5, 5, 8, 66 };
		int len = data.length;
		int start = 0;
		int end = len - 1;
		QuickSort3 qs = new QuickSort3();
		qs.quickSort(data, len, start, end);
		for (int i = 0; i < len; i++) {
			System.out.println(data[i]);
		}
	}

}
