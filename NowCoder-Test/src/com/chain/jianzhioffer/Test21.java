package com.chain.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * 举例让抽象具体化
 * 
 * @author chain
 *
 */
public class Test21 {

	private TreeNode root;
	private ArrayList<Integer> lst;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	// 层次遍历，借助队列
	private void test1() {
		fun1(root);
	}

	private void fun1(TreeNode node) {
		if (node == null)
			return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);

		while (queue.size() > 0) {
			TreeNode hn = queue.poll();
			lst.add(hn.val);
			if (hn.left != null)
				queue.add(hn.left);
			if (hn.right != null)
				queue.add(hn.right);
		}
	}

	private void input() {
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(1);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(2);

		root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
		n3.left = n7;
		n7.right = n8;
	}

	private void output() {
		for (int i : lst)
			System.out.print(i + " ");
		System.out.println();
	}

	private void init() {
		lst = new ArrayList<>();
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
