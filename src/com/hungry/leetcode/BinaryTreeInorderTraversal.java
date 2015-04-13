package com.hungry.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> resList = new LinkedList<Integer>();
		inorder(resList, root);
		return resList;
	}

	private static void inorder(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(list, root.left);
		list.add(root.val);
		inorder(list, root.right);
	}
	
	//模拟递归
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> resList = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			resList.add(root.val);
			root = root.right;
		}
		return resList;
	}
}
