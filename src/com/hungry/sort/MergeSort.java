package com.hungry.sort;

public class MergeSort {
	
	private static <AnyType extends Comparable<? super AnyType>>
	void merge(AnyType[] a, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		while(leftPos<=leftEnd && rightPos <= rightEnd) {
			if(a[leftPos].compareTo(a[rightPos])<=0) {
				tmpArray[tmpPos++] = a[leftPos++];
			} else {
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}
		
		while(leftPos<=leftEnd) {
			tmpArray[tmpPos++] = a[leftPos++];
		}
		
		while(rightPos<=rightEnd) {
			tmpArray[tmpPos++] = a[rightPos++];
		}
		
		for(int i=0; i<numElements; i++, rightEnd--) {
			a[rightEnd] = tmpArray[rightEnd];
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType[] a, AnyType[] tmpArray, int left, int right) {
		if(left<right) {
			int center = (left + right)/2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center+1, right);
			merge(a, tmpArray, left, center+1, right);
		}
	}
	
	public static <AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType[] a) {
		AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];
		mergeSort(a, tmpArray, 0, a.length-1);
	}
	
	public static void main(String[] args) {
		Integer[] a = {1,7,9,3,4,8};
		mergeSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
