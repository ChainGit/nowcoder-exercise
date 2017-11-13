package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 
 * 解题思路
 * 
 * @author chain
 *
 */
public class Test17 {

	private TreeNode root;

	@Test
	public void test() {
		input();

		output();
		test1();
		output();
	}

	// 递归+前序遍历
	private void test1() {
		fun(root);
	}

	private void fun(TreeNode node) {
		if (node == null)
			return;

		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;

		fun(node.left);
		fun(node.right);
	}

	private void input() {
		TreeNode n11 = new TreeNode(8);
		TreeNode n12 = new TreeNode(8);
		TreeNode n13 = new TreeNode(7);
		TreeNode n14 = new TreeNode(9);
		TreeNode n15 = new TreeNode(2);
		TreeNode n16 = new TreeNode(4);
		TreeNode n17 = new TreeNode(7);

		root = n11;
		n11.left = n12;
		n11.right = n13;
		n12.left = n14;
		n12.right = n15;
		n15.left = n16;
		n15.right = n17;
	}

	private void preOrder(TreeNode n) {
		if (n == null)
			return;

		System.out.print(n.val + " ");
		preOrder(n.left);
		preOrder(n.right);
	}

	private void inOrder(TreeNode n) {
		if (n == null)
			return;

		inOrder(n.left);
		System.out.print(n.val + " ");
		inOrder(n.right);
	}

	private void output() {
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
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
