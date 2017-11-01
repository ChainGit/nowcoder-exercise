package com.chain.jianzhioffer;

import java.util.Scanner;

import org.junit.Test;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * 二叉树
 * 
 * @author chain
 *
 */
public class Test04 {

	private TreeNode root;

	// 前序遍历（根结点在第一个）
	private int[] p;
	// 中序遍历
	private int[] m;
	// 结点的个数
	private int n;

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

	private void test2() {
		root = new Solution04().reConstructBinaryTree(p, m);
	}

	// 大问题和小问题类似，可用递归
	private void test1() {
		int pleft = 0;
		int pright = n - 1;
		int mleft = 0;
		int mright = n - 1;
		root = fun1(pleft, pright, mleft, mright);
	}

	private TreeNode fun1(int pleft, int pright, int mleft, int mright) {
		int parentIndex = pleft;
		int parentValue = p[parentIndex];
		TreeNode parentNode = new TreeNode(parentValue);

		if (pleft == pright) {
			if (mleft == mright && p[pleft] == m[mleft])
				return parentNode;
			else
				throw new RuntimeException("error input");
		}

		// 在中序遍历中找到根结点的位置
		int middleIndex = mleft;
		while (middleIndex <= mright && m[middleIndex] != parentValue)
			middleIndex++;

		// 如果在中序遍历中找不到前序遍历的第一个元素的位置，则输入非法
		if (middleIndex == mright && m[middleIndex] != parentValue)
			throw new RuntimeException("error input");

		int leftLen = middleIndex - mleft;
		int pleftEnd = pleft + leftLen;
		if (leftLen > 0) {
			parentNode.left = fun1(pleft + 1, pleftEnd, mleft, middleIndex - 1);
		}
		if (leftLen < pright - pleft) {
			parentNode.right = fun1(pleftEnd + 1, pright, middleIndex + 1, mright);
		}
		return parentNode;
	}

	private void input() {
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			if (n < 1)
				return;
			p = new int[n];
			m = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = in.nextInt();
			for (int i = 0; i < n; i++)
				m[i] = in.nextInt();
		}
	}

	// 输出后序遍历，采用递归
	private void output() {
		System.out.print("前序遍历：");
		fout1(root);
		System.out.println();

		System.out.print("中序遍历：");
		fout2(root);
		System.out.println();

		System.out.print("后序遍历：");
		fout3(root);
		System.out.println();
	}

	private void fout2(TreeNode node) {
		if (node == null)
			return;

		fout2(node.left);
		System.out.print(node.val + " ");
		fout2(node.right);
	}

	private void fout1(TreeNode node) {
		if (node == null)
			return;

		System.out.print(node.val + " ");
		fout1(node.left);
		fout1(node.right);
	}

	private void fout3(TreeNode node) {
		if (node == null)
			return;

		fout3(node.left);
		fout3(node.right);
		System.out.print(node.val + " ");
	}

	private void init() {
		root = null;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return String.valueOf(val);
		}

	}

	class Solution04 {

		// 这里如果不成功则返回null，严格上应该是抛出异常
		public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
			if (pre == null || in == null)
				throw new RuntimeException("empty or null input");

			int plen = pre.length;
			int ilen = in.length;

			if (plen < 1 || ilen < 1 || plen != ilen)
				throw new RuntimeException("empty input or not equal length");

			int pleft = 0;
			int pright = plen - 1;
			int ileft = 0;
			int iright = ilen - 1;

			TreeNode root = fun(pre, in, pleft, pright, ileft, iright);
			return root;
		}

		private TreeNode fun(int[] pre, int[] in, int pl, int pr, int il, int ir) {
			int parentIndex = pl;
			int parentValue = pre[parentIndex];
			TreeNode parentNode = new TreeNode(parentValue);

			// 如果已经只有一个元素了
			if (pl == pr) {
				// 判断输入是否合法
				if (il == ir && pre[pl] == in[il])
					return parentNode;
				else
					throw new RuntimeException("error input element");
			}

			// 找到中序遍历中的父节点
			int inorderIndex = il;
			for (; inorderIndex <= ir && in[inorderIndex] != parentValue; inorderIndex++)
				;

			// 如果输入的数据非法，则找不到
			if (inorderIndex == ir && in[inorderIndex] != parentValue)
				throw new RuntimeException("error input element");

			// 当前父节点左子树的元素个数
			int leftLen = inorderIndex - il;
			// 左子树的边界
			int plr = pl + leftLen;

			// 左子树不为空
			if (leftLen > 0) {
				parentNode.left = fun(pre, in, pl + 1, plr, il, inorderIndex - 1);
			}

			// 右子树不为空
			if (leftLen < pr - pl) {
				parentNode.right = fun(pre, in, plr + 1, pr, inorderIndex + 1, ir);
			}

			return parentNode;
		}
	}

}
