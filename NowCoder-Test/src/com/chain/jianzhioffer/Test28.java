package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * 代码的鲁棒性
 * 
 * @author chain
 *
 */
public class Test28 {

	private ListNode head;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			if (next == null)
				head = current;
			current.next = prev;
			prev = current;
			current = next;
		}
	}

	private void input() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
	}

	private void output() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	private void init() {

	}

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

}
