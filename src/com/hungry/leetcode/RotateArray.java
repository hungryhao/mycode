package com.hungry.leetcode;

public class RotateArray {

	public void rotateArray(int[] nums, int k) {
		int len = nums.length;
		if (k != len) {
			if (k > len) {
				k = k % len;
			}
			int[] temp = new int[len];
			for (int j = 0; j < len - k; j++) {
				temp[j] = nums[j];
			}
			int counter = 0;
			for (int i = len - k; i < len; i++) {
				nums[counter++] = nums[i];
			}
			for (int j = 0; j < len - k; j++) {
				nums[counter++] = temp[j];
			}
		}
	}

	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] num = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 11;
		ra.rotateArray(num, k);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

}
