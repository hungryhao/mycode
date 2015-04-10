package com.hungry.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		if (numRows == 1) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			resList.add(list);
		}
		if (numRows == 2) {
			List<Integer> list1 = new ArrayList<Integer>();
			list1.add(1);
			resList.add(list1);
			List<Integer> list2 = new ArrayList<Integer>();
			list2.add(1);
			list2.add(1);
			resList.add(list2);
		}
		if (numRows > 2) {
			resList = generate(numRows - 1);
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			for (int i = 1; i < numRows - 1; i++) {
				list.add(resList.get(numRows - 2).get(i - 1)
						+ resList.get(numRows - 2).get(i));
			}
			list.add(1);
			resList.add(list);
		}
		return resList;
	}

	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				list.add(1);
			}
			resList.add(list);
			if (i > 1) {
				for (int j = 1; j < i; j++) {
					resList.get(i).set(
							j,
							resList.get(i - 1).get(j - 1)
									+ resList.get(i - 1).get(j));
				}
			}

		}
		return resList;
	}

	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		int numRows = 5;
		List<List<Integer>> resList = pt.generate2(numRows);
		for (List<Integer> list : resList) {
			for (Integer x : list) {
				System.out.print(x);
			}
			System.out.println();
		}
	}

}
