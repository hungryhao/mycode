package com.hungry.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> resList = new LinkedList<List<Integer>>();
		if (root == null) {
			return resList;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				root = queue.peek();
				if (root.left != null) {
					queue.offer(root.left);
				}
				if (root.right != null) {
					queue.offer(root.right);
				}
				list.add(queue.poll().val);
			}
			resList.add(0, list);
		}
		return resList;
	}
	
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> resList = new LinkedList<List<Integer>>();
		addLevel(resList, 0, root);
		return resList;
	}
	
	private static void addLevel(List<List<Integer>> list, int level, TreeNode root) {
		if(root==null) {
			return;
		}
		if(list.size()-1<level) {
			list.add(0, new LinkedList<Integer>());
		}
		list.get(list.size()-1-level).add(root.val);
		addLevel(list, level+1, root.left);
		addLevel(list, level+1, root.right);
	}
}

/*class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}*/