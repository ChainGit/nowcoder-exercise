package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * 解决面试题的思路
 * 
 * @author chain
 *
 */
public class Test26 {

	private String s;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		if (s == null)
			return;
		char[] chs = s.toCharArray();
		int len = chs.length;
		fun(chs, len, 0);
	}

	private void fun(char[] chs, int len, int current) {
		if (current == len)
			System.out.println(new String(chs));
		else
			for (int i = current; i < len; i++) {
				if (i != current) {
					char t = chs[current];
					chs[current] = chs[i];
					chs[i] = t;
				}

				fun(chs, len, current + 1);

				if (i != current) {
					char t = chs[current];
					chs[current] = chs[i];
					chs[i] = t;
				}
			}
	}

	private void input() {
		s = "abc";
	}

	private void output() {

	}

	private void init() {

	}

}
