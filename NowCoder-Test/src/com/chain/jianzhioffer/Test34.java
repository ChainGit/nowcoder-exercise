package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 题目：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。
 * 
 * 类型：时间空间效率的平衡
 * 
 * 书中：50
 * 
 * @author chain
 * 
 *         算法应该尽量是平台无关的，即在Java平台下不使用现有的API
 *
 */
public class Test34 {

	private String in;
	private int r;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		r = fun(in);
	}

	private final int N = 26;
	private final int M = N << 1;

	private int fun(String str) {
		if (str == null || str.length() < 1)
			return -1;

		char[] c = str.toCharArray();
		int len = c.length;
		int[] t = new int[M];
		for (int i = 0; i < M; i++)
			t[i] = -1;
		for (int i = 0; i < len; i++) {
			int e = c[i];
			if (e >= 'A' && e <= 'Z')
				e -= 'A' - N;
			else
				e -= 'a';
			if (t[e] == -1)
				t[e] = i;
			else if (t[e] != -2)
				t[e] = -2;
		}
		int min = len;
		for (int i = 0; i < M; i++)
			if (t[i] >= 0 && t[i] < min)
				min = t[i];
		return min;
	}

	private void input() {
		in = "kYVmIJVzYWPQLtIdKMmvkVSoKtqJANOfCCOfLVJEjjhbnPrDOwKCDeqhts";
	}

	private void output() {
		System.out.println(r);
	}

	private void init() {

	}

}
