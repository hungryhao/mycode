package com.hungry.leetcode;

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		int lenA = 1;
		int lenB = 1;
		ListNode h1 = headA;
		ListNode h2 = headB;
		while (h1.next != null) {
			h1 = h1.next;
			lenA++;
		}
		while (h2.next != null) {
			h2 = h2.next;
			lenB++;
		}
		if (h1 != h2) {
			return null;
		}
		int diff = lenA - lenB;
		if (diff > 0) {
			while (diff > 0) {
				headA = headA.next;
				diff--;
			}
		} else {
			while (diff < 0) {
				headB = headB.next;
				diff++;
			}
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
