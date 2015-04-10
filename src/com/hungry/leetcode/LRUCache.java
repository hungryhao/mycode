package com.hungry.leetcode;

import java.util.HashMap;

public class LRUCache {

	private HashMap<Integer, Node> map;
	private int capacity;
	private int count;
	private Node head;
	private Node tail;

	class Node {
		int key;
		int value;
		Node pre;
		Node post;
	}

	private void addNode(Node node) {
		node.pre = head;
		node.post = head.post;
		head.post.pre = node;
		head.post = node;
	}

	private void removeNode(Node node) {
		Node pre = node.pre;
		Node post = node.post;

		pre.post = post;
		post.pre = pre;
	}

	private void moveToHead(Node node) {
		this.removeNode(node);
		this.addNode(node);
	}

	private Node popTail() {
		Node res = tail.pre;
		this.removeNode(res);
		return res;
	}

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		head = new Node();
		head.pre = null;

		tail = new Node();
		tail.post = null;

		head.post = tail;
		tail.pre = head;
		map = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			if (node == null) {
				return -1;
			}
			this.moveToHead(node);
			return node.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;

			map.put(key, newNode);
			this.addNode(newNode);

			count++;

			if (count > capacity) {
				Node tail = this.popTail();
				map.remove(tail.key);
				count--;
			}
		} else {
			node.value = value;
			this.moveToHead(node);
		}
	}

}
