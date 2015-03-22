package com.hungry.select;

public class QuickSelect {

	private static final int CUTOFF = 10;

	private static <AnyType extends Comparable<? super AnyType>> void swapReferences(
			AnyType[] a, int left, int right) {
		AnyType tmp = a[left];
		a[left] = a[right];
		a[right] = tmp;
	}

	private static <AnyType extends Comparable<? super AnyType>> AnyType median3(
			AnyType[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[left].compareTo(a[center]) > 0) {
			swapReferences(a, left, center);
		}
		if (a[left].compareTo(a[right]) > 0) {
			swapReferences(a, left, right);
		}
		if (a[center].compareTo(a[right]) > 0) {
			swapReferences(a, center, right);
		}

		swapReferences(a, center, right - 1);
		return a[right - 1];
	}

	private static <AnyType extends Comparable<? super AnyType>> void insertSort(
			AnyType[] a, int left, int right) {
		int j;
		for (int i = left; i <= right; i++) {
			AnyType tmp = a[i];
			for (j = i; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}

	private static <AnyType extends Comparable<? super AnyType>> void quickSelect(
			AnyType[] a, int left, int right, int k) {
		if (left + CUTOFF <= right) {
			AnyType pivot = median3(a, left, right);

			int i = left, j = right - 1;
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

			if (k <= i) {
				quickSelect(a, left, i - 1, k);
			} else if (k > i + 1) {
				quickSelect(a, i + 1, right, k);
			}

		} else {
			insertSort(a, left, right);
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType>>
	AnyType quickSelect(AnyType[] a, int k) {
		quickSelect(a, 0, a.length-1, k);
		return a[k-1];
	}
	
	public static void main(String[] args) {
		Integer[] a = {1,2,6,33,5,66,9,7,11,22,3,55};
		int k = 4;
		int result = quickSelect(a, k);
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println(result);
		
	}

}
