package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) +
 * ... + f(n-1) == f(n) = 2*f(n-1)
 * 
 * 斐波那契数列
 * 
 * @author chain
 *
 */
public class Test09 {

	@Test
	public void test1() {
		System.out.println(test1(10));
	}

	// 循环使用数组做法
	private int test1(int n) {
		if (n < 2)
			return n;
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i <= n; i++)
			f[i] = 2 * f[i - 1];
		return f[n];
	}

}
