package com.hungry.sort;

public class QuickSort2 {
	
	private final static int CUTOFF = 10;

	private static <AnyType extends Comparable<? super AnyType>> void swapReferences(
			AnyType[] a, int i, int n) {
		AnyType tmp = a[i];
		a[i] = a[n];
		a[n] = tmp;
	}

	private static <AnyType extends Comparable<? super AnyType>> AnyType median3(
			AnyType[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[center].compareTo(a[left]) < 0) {
			swapReferences(a, left, center);
		}
		if (a[right].compareTo(a[left]) < 0) {
			swapReferences(a, left, right);
		}
		if (a[right].compareTo(a[center]) < 0) {
			swapReferences(a, center, right);
		}

		swapReferences(a, center, right - 1);
		return a[right - 1];
	}
	
	//最左最右和中间的值的中间值作为pivot，cutoff表示在此之下用插入排序更快
	private static <AnyType extends Comparable<? super AnyType>> void quickSort(
			AnyType[] a, int left, int right) {
		if (left + CUTOFF <= right) {
			AnyType pivot = median3(a, left, right);

			int i = left;
			int j = right - 1;
			for (;;) {
				while (a[++i].compareTo(pivot) < 0) {
				}
				while (a[--j].compareTo(pivot) > 0) {
				}
				if (i < j) {
					swapReferences(a, i, j);
				} else {
					break;
				}
			}

			swapReferences(a, i, right - 1);
			// System.out.println(i);
			quickSort(a, left, i - 1);
			quickSort(a, i + 1, right);
		} else {
			insertSort(a, left, right);
		}
	}

	private static <AnyType extends Comparable<? super AnyType>> void insertSort(
			AnyType[] num, int left, int right) {
		int j;
		for (int i = left; i <= right; i++) {
			AnyType k = num[i];
			for (j = i; j > left && k.compareTo(num[j - 1]) < 0; j--) {
				num[j] = num[j - 1];
			}
			num[j] = k;
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 7, 9, 3, 4, 8 };
		quickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
