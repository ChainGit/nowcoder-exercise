package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
 * 
 * @author chain
 *
 */
public class Test07 {

	@Test
	public void test1() {
		System.out.println(test1(10));
	}

	// 循环不使用数组做法
	private int test1(int n) {
		if (n < 2)
			return n;
		int f0 = 0;
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
