package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 * 
 * 时间效率
 * 
 * 书中题42
 * 
 * @author chain
 *
 */
public class Test30 {

	private int[] a;
	private int r;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		r = fun(a);
	}

	// 动态规划
	private int fun(int[] array) {
		int[] a = array;
		if (a == null || a.length < 1)
			throw new RuntimeException("array can not be null or empty");
		int len = a.length;
		int sum = 0;
		int max = 0;
		boolean flag = false;
		for (int i = 0; i < len; i++) {
			if (sum <= 0)
				sum = a[i];
			else
				sum += a[i];

			if (!flag || sum > max) {
				max = sum;
				flag = true;
			}
		}
		return max;
	}

	private void input() {
		a = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
	}

	private void output() {
		System.out.println(r);
	}

	private void init() {

	}
}
