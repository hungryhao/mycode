package com.hungry.leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> resList = new LinkedList<Integer>();
		postorder(resList, root);
		return resList;
	}

	private static void postorder(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		postorder(list, root.left);
		postorder(list, root.right);
		list.add(root.val);
	}

}
