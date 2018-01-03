package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 
 * @author chain
 *
 */
public class Test29 {

	private int[] a;
	private int k;

	private int[] r;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	// 牛客网的返回减少null，而是返回一个空的集合
	private void test1() {
		r = fun(a, k);
	}

	// 新建一个容器，类似插入排序的方法
	private int[] fun(int[] input, int k) {
		int[] a = input;
		if (a == null || k < 1)
			return null;
		// k可能大于或等于len
		int len = a.length;
		int alen = len > k ? k : len;
		int[] r = new int[k];
		r[0] = a[0];
		boolean insert = false;
		for (int i = 1, p = 1; i < len; i++) {
			insert = false;
			for (int j = 0; j < p; j++) {
				if (r[j] > a[i]) {
					for (int m = p; m > j; m--)
						if (m < alen)
							r[m] = r[m - 1];
					r[j] = a[i];
					insert = true;
					if (p < alen)
						p++;
					break;
				}
			}
			if (!insert && p < alen)
				r[p++] = a[i];
		}
		if (len <= k) {
			int[] m = new int[alen];
			for (int i = 0; i < alen; i++)
				m[i] = r[i];
			r = m;
		}
		return r;
	}

	private void input() {
		a = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
		k = 4;
	}

	private void output() {
		for (int i = 0; i < k; i++)
			System.out.print(r[i] + " ");
		System.out.println();
	}

	private void init() {

	}
}
