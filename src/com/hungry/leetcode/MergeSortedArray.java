package com.hungry.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		for (int i = 0; i < n; i++) {
			A[m + i] = B[i];
		}
		for (int i = 0; i < m + n - 1; i++) {
			for (int j = i + 1; j < m + n; j++) {
				if (A[i] > A[j]) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
	}

	// test
	public void merge2(int A[], int m, int B[], int n) {
		TreeSet tree = new TreeSet();
		for (int i = 0; i < m; i++) {
			tree.add(new Integer(A[i]));
		}
		for (int j = 0; j < n; j++) {
			tree.add(new Integer(B[j]));
		}
		Iterator it = tree.iterator();
		List list = new ArrayList();
		while (it.hasNext()) {
			list.add(it.next().toString());
		}
		for (int x = 0; x < list.size(); x++) {
			A[x] = new Integer((String) list.get(x)).intValue();
		}
	}

	public void merge3(int[] A, int m, int B[], int n) {
		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[m + n - 1] = A[m - 1];
				m--;
			} else {
				A[m + n - 1] = B[n - 1];
				n--;
			}
		}

		while (n > 0) {
			A[n - 1] = B[n - 1];
			n--;
		}
	}

	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		int[] A = new int[m + n];
		A[0] = 3;
		A[1] = 5;
		A[2] = 7;
		int[] B = { 2, 3 };
		MergeSortedArray ms = new MergeSortedArray();
		ms.merge3(A, m, B, n);
		for (int i = 0; i < m + n; i++) {
			System.out.println(A[i]);
		}
	}

}
