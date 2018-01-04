package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 题目：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13，因此共出现6次。 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他，并把问题更加普遍化，可以很快的求出任意非负整数区间中1出现的次数。
 * 
 * 类型：
 * 
 * 书中：
 * 
 * @author chain
 *
 */
public class Test31 {

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

	private int fun(int n) {
		if (n < 0)
			throw new RuntimeException("n>=0");
		int[] a = n2a(n);
		return recursive(a, a.length, 0);
	}

	private int recursive(int[] a, final int total, int i) {
		int len = total - i;

		if (len <= 0)
			return 0;

		int first = a[i];
		if (len == 1) {
			if (first > 0)
				return 1;
			else
				return 0;
		}

		int n = 0;
		if (first > 1) {
			n += p10(total - i - 1);
		} else if (first == 1) {
			n += a2n(a, i + 1, total) + 1;
		}

		n += first * (len - 1) * p10(len - 2);

		return n + recursive(a, total, i + 1);
	}

	private int p10(int i) {
		int r = 1;
		while (i-- > 0)
			r *= 10;
		return r;
	}

	private int a2n(int[] a, int begin, int end) {
		int n = 0;
		for (int i = begin; i < end; i++)
			n = n * 10 + a[i];
		return n;
	}

	private int[] n2a(int n) {
		int t = n;
		int p = 1;
		while ((t /= 10) != 0)
			p++;
		int[] r = new int[p--];
		while (n != 0) {
			t = n % 10;
			r[p--] = t;
			n /= 10;
		}
		return r;
	}

	private void input() {
		n = 21345;
	}

	private void output() {
		System.out.println(r);
	}

	private void init() {

	}

}
