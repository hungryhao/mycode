package com.hungry.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> resList = new LinkedList<Integer>();
		preorder(resList, root);
		return resList;
	}

	private static void preorder(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preorder(list, root.left);
		preorder(list, root.right);
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> resList = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			resList.add(root.val);
			if (root.right != null) {
				stack.push(root.right);
			}
			root = root.left;
			if (root == null && !stack.isEmpty()) {
				root = stack.pop();
			}
		}
		return resList;
	}

	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> resList = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			if (root != null) {
				resList.add(root.val);
				stack.push(root.right);
				stack.push(root.left);
			}
		}
		return resList;
	}
	
	//模拟递归
	public List<Integer> preorderTraversal4(TreeNode root) {
		List<Integer> resList = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				resList.add(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
		return resList;
		
	}

}
