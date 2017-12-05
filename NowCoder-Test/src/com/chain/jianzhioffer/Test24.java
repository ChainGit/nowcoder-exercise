package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点，注意不是类似图这么复杂的，只是一个单向链表，链表中的值不重复），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * 分解让复杂问题简单
 * 
 * @author chain
 *
 */
public class Test24 {

	private RandomListNode head;

	private RandomListNode copy;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();

		System.out.println();

		init();
		test2();
		output();
	}

	// O(n^2)
	private void test1() {
		copy = clone1(head);
	}

	// O(n)
	private void test2() {
		copy = clone2(head);
	}

	private RandomListNode clone1(RandomListNode head) {
		if (head == null)
			return null;

		RandomListNode node = new RandomListNode(head.label);
		RandomListNode copy = node;
		RandomListNode current = head.next;
		while (current != null) {
			node.next = new RandomListNode(current.label);
			node = node.next;
			current = current.next;
		}

		current = head;
		node = copy;
		while (node != null && current != null) {
			if (current.random != null) {
				RandomListNode i = copy;
				for (; i != null; i = i.next)
					if (i.label == current.random.label)
						break;
				node.random = i;
			}
			current = current.next;
			node = node.next;
		}
		return copy;
	}

	private RandomListNode clone2(RandomListNode head) {
		if (head == null)
			return null;

		RandomListNode current = head;
		RandomListNode last = null;
		RandomListNode temp = null;
		while (current != null) {
			temp = new RandomListNode(current.label);
			last = current;
			current = current.next;
			last.next = temp;
			temp.next = current;
		}

		current = head;
		while (current != null) {
			if (current.random != null)
				current.next.random = current.random.next;
			current = current.next.next;
		}

		current = head;
		RandomListNode copy = current.next;
		temp = copy;
		while (current != null && temp != null) {
			last = current;
			current = current.next.next;
			if (current == null) {
				last.next = null;
				break;
			}
			temp.next = current.next;
			temp = temp.next;
			last.next = current;
		}

		return copy;
	}

	private void input() {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);

		head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n1.random = n3;
		n2.random = n5;
		n4.random = n2;
	}

	private void output() {
		RandomListNode current = head;
		while (current != null) {
			System.out.println(current.label + (current.random != null ? " " + current.random.label : ""));
			System.out.println(current.hashCode() + (current.random != null ? " " + current.random.hashCode() : ""));
			current = current.next;
		}

		System.out.println();

		current = copy;
		while (current != null) {
			System.out.println(current.label + (current.random != null ? " " + current.random.label : ""));
			System.out.println(current.hashCode() + (current.random != null ? " " + current.random.hashCode() : ""));
			current = current.next;
		}
	}

	private void init() {
		copy = null;
	}

	class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

}
