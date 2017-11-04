package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * 简单的题目不简单
 * 
 * @author chain
 *
 */
public class Test12 {

	@Test
	public void test() {
		System.out.println(test1(0.0, 0));
		System.out.println(test1(1.0, 0));
		System.out.println(test1(0.0, 1));
		System.out.println(test1(-1.0, -2));
		System.out.println(test1(2.0, 2));
		System.out.println(test1(2.1, -2));
		System.out.println(test1(2.0, 3));
	}

	// 这里不考虑结果溢出
	private double test1(double b, int e) {
		if (e < 0) {
			b = 1 / b;
			e = -e;
		}
		return quickPow(b, e);
	}

	private double quickPow(double b, int e) {
		double r = 1.0;
		while (e != 0) {
			// 如果是奇数
			if ((e & 1) == 1)
				r *= b;
			e >>>= 1;
			b *= b;
		}
		return r;
	}
}
