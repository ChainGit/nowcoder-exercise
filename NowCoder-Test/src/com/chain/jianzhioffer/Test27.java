package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * 时间效率
 * 
 * @author chain
 *
 */
public class Test27 {

	private int[] a;
	private int t;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		if (a == null)
			return;
		int len = a.length;
		if (len < 1)
			return;

		t = a[0];
		int n = 1;
		for (int i = 1; i < len; i++)
			if (n == 0) {
				t = a[i];
				n = 1;
			} else if (a[i] == t) {
				n++;
			} else {
				n--;
			}

		n = 0;
		boolean ok = false;
		for (int i = 0; i < len; i++) {
			if (a[i] == t)
				n++;
			if (n << 1 > len) {
				ok = true;
				break;
			}
		}

		if (!ok)
			t = 0;
	}

	private void input() {
		a = new int[] { 1, 2, 3, 2, 4, 2, 5, 2, 3 };
	}

	private void output() {
		System.out.println(t);
	}

	private void init() {
		t = 0;
	}

}
