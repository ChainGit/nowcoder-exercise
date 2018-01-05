package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 题目：把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * 类型： 时间空间效率的平衡
 * 
 * 书中：49
 * 
 * @author chain
 * 
 *         算法应该尽量是平台无关的，即在Java平台下不使用现有的API
 *
 */
public class Test33 {

	private int n;
	private int r;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		r = fun(n);
	}

	// 空间换时间
	private int fun(int index) {
		int n = index;
		if (n <= 0)
			return 0;

		int[] t = new int[n];
		t[0] = 1;

		int p = 1;
		int a = 0, b = 0, c = 0;

		while (p < n) {
			int m = min(t[a] * 2, t[b] * 3, t[c] * 5);
			t[p++] = m;

			while (t[a] * 2 <= m)
				a++;
			while (t[b] * 3 <= m)
				b++;
			while (t[c] * 5 <= m)
				c++;
		}

		return t[p - 1];
	}

	private int min(int i, int j, int k) {
		int p = i > j ? j : i;
		return p > k ? k : p;
	}

	private void input() {
		n = 4;
	}

	private void output() {
		System.out.println(r);
	}

	private void init() {

	}

}
