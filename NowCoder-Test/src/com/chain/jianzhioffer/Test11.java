package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * 计算机基础知识，位运算
 * 
 * @author chain
 *
 */
public class Test11 {

	@Test
	public void test() {
		System.out.println(test1(10));
		System.out.println(test1(-10));
	}

	private int test1(int n) {
		int t = 0;
		while (n != 0) {
			int p = n & 1;
			if (p == 1)
				t++;
			n >>>= 1;
		}
		return t;
	}

}
