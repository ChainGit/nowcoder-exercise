package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * 解决面试题的思路
 * 
 * @author chain
 *
 */
public class Test25 {

	private TreeNode root;
	private TreeNode list;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		fun(root);
		list = head;
	}

	private TreeNode head;
	private TreeNode tail;

	private void fun(TreeNode current) {
		if (current == null)
			return;

		if (current.left != null)
			fun(current.left);

		current.left = tail;
		if (tail != null)
			tail.right = current;
		tail = current;

		if (head == null)
			head = tail;

		if (current.right != null)
			fun(current.right);
	}

	private void input() {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(14);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(12);
		TreeNode n7 = new TreeNode(16);

		root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
	}

	private void output() {
		TreeNode n = list;
		System.out.println(head.val);
		System.out.println(tail.val);
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.right;
		}
		System.out.println();
	}

	private void init() {
		list = null;
	}

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

}
