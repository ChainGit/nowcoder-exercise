package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树(排序二叉树)的后序遍历的结果。 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * 举例让抽象具体化
 * 
 * @author chain
 *
 */
public class Test22 {

	private int[] a;
	private boolean r;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		// 长度为0则返回false
		if (a == null || a.length < 1) {
			r = false;
			return;
		}
		// 长度为1和2都是直接返回true
		else if (a.length < 3) {
			r = true;
			return;
		}

		r = fun(0, a.length - 2, a.length - 1);

	}

	private boolean fun(int left, int right, int root) {
		if (right - left < 1)
			return true;

		int rootVal = a[root];

		// 找到左子树，所有的元素均小于根
		int i;
		for (i = left; i <= right; i++)
			if (a[i] > rootVal)
				break;

		// 判断右子树，所有的元素都大于根
		int j = i;
		for (; j <= right; j++)
			if (a[j] < rootVal)
				return false;

		boolean le = true, ri = true;

		if (i > 2)
			le = fun(left, i - 2, i - 1);

		if (i < right)
			ri = fun(i, right - 1, right);

		return le && ri;
	}

	private void input() {
		a = new int[] {};
		a = new int[] { 5 };
		a = new int[] { 5, 7 };
		a = new int[] { 9, 7 };
		a = new int[] { 5, 7, 6, 9, 11, 10, 8 };
		a = new int[] { 7, 4, 6, 5 };
	}

	private void output() {
		System.out.println(r);
	}

	private void init() {
		r = true;
	}

}
