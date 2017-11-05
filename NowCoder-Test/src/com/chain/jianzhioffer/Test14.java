package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 链表
 * 
 * 鲁棒性
 * 
 * @author chain
 *
 */
public class Test14 {

	private ListNode head;

	private int k;

	private int nodeKVal;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	class Solution14 {
		public ListNode FindKthToTail(ListNode head, int k) {
			if (head == null || k == 0)
				return null;

			ListNode current = head;
			for (int i = 1; i < k; i++) {
				current = current.next;
				if (current == null)
					return null;
			}

			ListNode nodeK = head;
			while (current.next != null) {
				current = current.next;
				nodeK = nodeK.next;
			}

			return nodeK;
		}
	}

	private void output() {
		System.out.println(nodeKVal);
	}

	private void init() {
		k = 3;
		nodeKVal = -1;
	}

	private void test1() {
		if (head == null || k == 0)
			throw new RuntimeException("list is null or k should larger than 0");

		ListNode current = head;
		for (int i = 1; i < k; i++) {
			current = current.next;
			if (current == null)
				throw new RuntimeException("k is out of range");
		}

		ListNode nodeK = head;
		while (current.next != null) {
			current = current.next;
			nodeK = nodeK.next;
		}

		nodeKVal = nodeK.val;
	}

	private void input() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		// 单向非闭合链表
		head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
	}

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
