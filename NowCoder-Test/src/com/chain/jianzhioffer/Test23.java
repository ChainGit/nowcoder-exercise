package com.chain.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * 举例让抽象具体化
 * 
 * @author chain
 *
 */
public class Test23 {

	private ArrayList<ArrayList<Integer>> lst;
	private TreeNode root;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		lst = findPath(root, 22);
	}

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
		LinkedList<Integer> stack = new LinkedList<>();
		int sum = 0;
		fun(sum, stack, lst, root, target);
		return lst;
	}

	private void fun(int sum, LinkedList<Integer> stack, ArrayList<ArrayList<Integer>> lst, TreeNode node, int target) {
		if (node == null)
			return;

		int val = node.val;
		stack.push(val);
		sum += val;

		if (sum == target && node.left == null && node.right == null)
			add(stack, lst);

		fun(sum, stack, lst, node.left, target);
		fun(sum, stack, lst, node.right, target);

		stack.pop();
		sum -= val;
	}

	private void add(LinkedList<Integer> stack, ArrayList<ArrayList<Integer>> lst) {
		ArrayList<Integer> ans = new ArrayList<>();
		// ans.addAll(stack);
		int size = stack.size();
		for (int i = size - 1; i > -1; i--)
			ans.add(stack.get(i));
		lst.add(ans);
	}

	private void input() {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(12);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);

		root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
	}

	private void output() {
		for (ArrayList<Integer> al : lst) {
			for (int i : al)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	private void init() {
		// lst = new ArrayList<>();
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
