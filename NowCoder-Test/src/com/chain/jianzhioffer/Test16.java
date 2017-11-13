package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * 鲁棒性
 * 
 * @author chain
 *
 */
public class Test16 {

	private TreeNode root1;
	private TreeNode root2;

	private boolean r;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	// 递归
	private void test1() {
		if (root1 == null || root2 == null)
			return;
		r = find(root1, root2);
	}

	// 找到B的根结点在A中的位置
	private boolean find(TreeNode r1, final TreeNode r2) {
		if (r1 == null)
			return false;

		// 如果找到则进一步判断
		if (r1.val == r2.val && check(r1, r2))
			return true;

		return find(r1.left, r2) || find(r1.right, r2);
	}

	// 进一步检查
	private boolean check(TreeNode r1, TreeNode r2) {
		if (r2 == null)
			return true;
		else if (r1 == null || (r1.val != r2.val))
			return false;

		return check(r1.left, r2.left) && check(r1.right, r2.right);
	}

	private void input() {
		TreeNode n11 = new TreeNode(8);
		TreeNode n12 = new TreeNode(8);
		TreeNode n13 = new TreeNode(7);
		TreeNode n14 = new TreeNode(9);
		TreeNode n15 = new TreeNode(2);
		TreeNode n16 = new TreeNode(4);
		TreeNode n17 = new TreeNode(7);

		TreeNode n21 = new TreeNode(8);
		// TreeNode n21 = new TreeNode(7);
		// TreeNode n21 = new TreeNode(0);
		TreeNode n22 = new TreeNode(9);
		// TreeNode n22 = new TreeNode(1);
		TreeNode n23 = new TreeNode(2);
		// TreeNode n24 = new TreeNode(7);

		root1 = n11;
		n11.left = n12;
		n11.right = n13;
		n12.left = n14;
		n12.right = n15;
		n15.left = n16;
		n15.right = n17;

		root2 = n21;
		n21.left = n22;
		n21.right = n23;
		// n23.right = n24;
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
		preOrder(root1);
		System.out.println();
		inOrder(root1);
		System.out.println();

		preOrder(root2);
		System.out.println();
		inOrder(root2);
		System.out.println();

		System.out.println(r);
	}

	private void init() {
		r = false;
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
