package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * 动态规划
 * 
 * 其实斐波那契数能体现出动态规划和分治
 * 
 * @author chain
 *
 */
public class Test10 {

	@Test
	public void test1() {
		System.out.println(test1(10));
	}

	private int test1(int n) {
		if (n < 3)
			return n;
		int[] f = new int[n + 1];
		f[1] = 1;
		f[2] = 2;
		for (int i = 3; i <= n; i++)
			f[i] = f[i - 1] + f[i - 2];
		return f[n];
	}

}
