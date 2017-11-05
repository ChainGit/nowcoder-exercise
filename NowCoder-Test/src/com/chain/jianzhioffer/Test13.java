package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 数组
 * 
 * @author chain
 *
 */
public class Test13 {

	@Test
	public void test() {
		int[] a = { 4, 6, 5, 3, 2, 8, 1, 6, 7 };

		int[] a1 = a.clone();
		test1(a1);
		output(a1);

		int[] a2 = a.clone();
		test2(a2);
		output(a2);
	}

	private void output(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	// 一个数组，时间复杂度高，空间复杂度低，类似插入排序原理，如果不需要保持相对位置，可以使用类似快速排序的方法
	private void test2(int[] a) {
		int len = a.length;
		int p = 0;
		for (int i = 0; i < len; i++) {
			int t = a[i];
			if ((t & 1) == 1) {
				for (int j = i; j > p; j--)
					a[j] = a[j - 1];
				a[p++] = t;
			}
		}
	}

	// 两个数组，再分别输出，时间复杂度O(n)，空间复杂度比较高
	private void test1(int[] a) {
		int len = a.length;
		// 存放偶数
		int[] o = new int[len];
		// 存放奇数
		int[] e = new int[len];
		int i = 0, j = 0, k = 0;
		for (; i < len; i++) {
			int t = a[i];
			if (t % 2 == 0)
				o[j++] = t;
			else
				e[k++] = t;
		}
		i = 0;
		for (int p = 0; p < k; p++)
			a[i++] = e[p];
		for (int p = 0; p < j; p++)
			a[i++] = o[p];
	}

}
