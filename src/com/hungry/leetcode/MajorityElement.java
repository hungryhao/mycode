package com.hungry.leetcode;

import java.util.HashMap;
import java.util.Iterator;

public class MajorityElement {

	// O(n)
	public int majorityElement(int[] num) {
		HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			int temp = num[i];
			if (numMap.containsKey(temp)) {
				numMap.put(temp, numMap.get(temp) + 1);
			} else {
				numMap.put(temp, 1);
			}
		}
		Iterator iterator = numMap.keySet().iterator();
		while (iterator.hasNext()) {
			int key = (Integer) iterator.next();
			int value = numMap.get(key);
			if (value > num.length / 2) {
				return key;
			}
		}
		return -1;
	}

	// O(n)
	public int majorityElement2(int[] num) {
		int counter = 0;
		int x = 0;
		for (int i = 0; i < num.length; i++) {
			if (counter == 0) {
				x = num[i];
				counter++;
			} else if (num[i] == x) {
				counter++;
			} else {
				counter--;
			}
		}
		System.out.println(counter);
		if (counter > 0) {
			return x;
		}
		return -1;
	}

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int[] num = { 1, 1, 2, 3, 4, 2, 2 };
		int key = me.majorityElement(num);
		System.out.println(key);
	}

}
