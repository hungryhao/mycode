package com.hungry.leetcode;

public class MedianOfTwoSortedArrays {
	
	private int findKth(int[] a, int m, int[] b, int n, int k) {
		if(m>n) {
			return findKth(b,n,a,m,k);
		}
		if(m==0) {
			return b[k-1];
		}
		if(k==1) {
			return a[0]<b[0]?a[0]:b[0];
		}
		int tmpa = k/2<m?k/2:m;
		int tmpb = k-tmpa;
		if(a[tmpa-1]<b[tmpb-1]) {
			int[] dest = new int[m-tmpa];
			System.arraycopy(a, tmpa, dest, 0, m-tmpa);
			return findKth(dest,m-tmpa,b,n,k-tmpa);
		} else if(a[tmpa-1]>b[tmpb-1]) {
			int[] dest = new int[n-tmpb];
			System.arraycopy(b, tmpb, dest, 0, n-tmpb);
			return findKth(a,m,dest,n-tmpb,k-tmpb);
		} else {
			return a[tmpa-1];
		}
		
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m+n;
		if(total%2!=0) {
			return findKth(A,m,B,n,total/2+1);
		} else {
			return (findKth(A,m,B,n,total/2)+ findKth(A, m, B, n, total / 2 + 1)) / 2;
		}
	}

}
