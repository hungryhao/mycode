package com.hungry.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> resList = new LinkedList<List<Integer>>();
		if(root==null) {
			return resList;
		}
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> list = new LinkedList<Integer>();
			for(int i=0; i<levelNum; i++) {
				root = queue.peek();
				if(root.left!=null) {
					queue.offer(root.left);
				}
				if(root.right!=null) {
					queue.offer(root.right);
				}
				list.add(queue.poll().val);
			}
			resList.add(list);
		}
		return resList;
	}
		
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}