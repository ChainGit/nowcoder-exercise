package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 斐波拉契数列的变形，把斐波拉契数列的每一项向前移动了1位
 * 
 * @author chain
 *
 */
public class Test08 {

	@Test
	public void test1() {
		System.out.println(test1(10));
	}

	// 循环不使用数组做法
	private int test1(int n) {
		if (n < 2)
			return n;
		int f0 = 1;
		int f1 = 1;
		int f2 = f0 + f1;
		for (int i = 2; i <= n; i++) {
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f2;
	}
}
