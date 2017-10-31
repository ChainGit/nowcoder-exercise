package com.chain.jianzhioffer;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 输入一个单向链表，从尾到头打印链表每个节点的值。
 * 
 * 链表
 * 
 * @author chain
 *
 */
public class Test03 {

	private ListNode head;

	private ListNode nhead;

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

	// 利用系统运行栈（数据量大容易溢出）
	private void test2() {
		ListNode current = head;
		fun(current);
	}

	ListNode cursor = null;

	private void fun(ListNode current) {
		if (current == null)
			return;

		fun(current.next);

		if (nhead == null) {
			nhead = new ListNode(current.val);
			cursor = nhead;
		} else {
			cursor.next = new ListNode(current.val);
			cursor = cursor.next;
		}
	}

	// 基于栈的数据结构
	private void test1() {
		LinkedList<Integer> stack = new LinkedList<>();
		ListNode current = head;
		while (current != null) {
			stack.push(current.val);
			current = current.next;
		}

		// 通过弹栈，构建反序单链表，相当于单链表的翻转
		nhead = new ListNode(stack.pop());
		current = nhead;
		while (!stack.isEmpty()) {
			// 原链表和翻转后的链表内的元素是独立的对象
			ListNode node = new ListNode(stack.pop());
			current.next = node;
			current = node;
		}
	}

	private void input() {
		head = new ListNode(0);
		ListNode current = head;
		for (int i = 1; i < 10; i++) {
			ListNode node = new ListNode(i);
			current.next = node;
			current = node;
		}
	}

	private void output() {
		ListNode current = nhead;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	private void init() {
		nhead = null;
	}

	// 不改变数据结构，单链表
	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

}
