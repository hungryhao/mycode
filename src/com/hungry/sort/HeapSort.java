package com.hungry.sort;

public class HeapSort {

	private int leftChild(int i) {
		return 2 * i + 1;
	}

	private void percDown(int[] num, int i, int n) {
		int child;
		int tmp;
		for (tmp = num[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && num[child] < num[child + 1]) {
				child++;
			}
			if (tmp < num[child]) {
				num[i] = num[child];
			} else {
				break;
			}
		}
		num[i] = tmp;
	}

	private void swapReferences(int[] num, int i, int n) {
		int tmp = num[i];
		num[i] = num[n];
		num[n] = tmp;
	}

	public void heapSort(int[] num) {
		for (int i = num.length / 2 - 1; i >= 0; i--) {
			percDown(num, i, num.length);
		}
		for (int i = num.length - 1; i > 0; i--) {
			swapReferences(num, 0, i);
			percDown(num, 0, i);
		}
	}

	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
		int[] num = { 1, 2, 8, 3, 7 };
		hs.heapSort(num);

		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
