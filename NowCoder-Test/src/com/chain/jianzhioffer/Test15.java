package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * 链表
 * 
 * @author chain
 *
 */
public class Test15 {

	private ListNode head1;
	private ListNode head2;
	private ListNode phead;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();

		init();
		test2();
		output();
	}

	// 递归做法
	private void test2() {
		phead = fun(head1, head2);
	}

	private ListNode fun(ListNode h1, ListNode h2) {
		if (h1 == null)
			return h2;
		else if (h2 == null)
			return h1;

		ListNode ph = null;

		int v1 = h1.val;
		int v2 = h2.val;
		if (v1 > v2) {
			ph = new ListNode(v2);
			ph.next = fun(h1, h2.next);
		} else {
			ph = new ListNode(v1);
			ph.next = fun(h1.next, h2);
		}

		return ph;
	}

	private void output() {
		ListNode current = phead;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	// 循环做法
	private void test1() {
		ListNode h1 = head1;
		ListNode h2 = head2;
		ListNode ph = phead;

		ListNode tmp = null;
		while (h1 != null && h2 != null) {
			int v1 = h1.val;
			int v2 = h2.val;
			boolean status = v1 > v2;
			tmp = status ? new ListNode(v2) : new ListNode(v1);
			if (ph == null) {
				ph = tmp;
				phead = ph;
			} else
				ph.next = tmp;
			if (status)
				h2 = h2.next;
			else
				h1 = h1.next;
			if (ph.next != null)
				ph = ph.next;
		}

		if (h1 == null) {
			if (ph != null)
				ph.next = h2;
			else {
				ph = h2;
				phead = ph;
			}
		} else if (h2 == null) {
			if (ph != null)
				ph.next = h1;
			else {
				ph = h1;
				phead = ph;
			}
		}

	}

	private void init() {
		phead = null;
	}

	private void input() {
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(7);
		ListNode n14 = new ListNode(9);
		head1 = n11;
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;

		ListNode n21 = new ListNode(3);
		ListNode n22 = new ListNode(6);
		ListNode n23 = new ListNode(7);
		ListNode n24 = new ListNode(8);
		ListNode n25 = new ListNode(10);
		head2 = n21;
		n21.next = n22;
		n22.next = n23;
		n23.next = n24;
		n24.next = n25;
	}

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

}
