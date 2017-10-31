package com.chain.jianzhioffer;

import java.util.Scanner;

import org.junit.Test;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 字符串
 * 
 * @author chain
 *
 */
public class Test02 {

	private String src;
	private String dst;

	private static String BLANK = "%20";

	@Test
	public void test() {
		input();

		init();
		test1();
		output();

		init();
		test2();
		output();

		init();
		test3();
		output();
	}

	// 不使用JavaAPI
	private void test3() {
		if (src == null || src.length() < 1) {
			dst = src;
			return;
		}
		char[] chs = src.toCharArray();
		int clen = chs.length;
		// 记录空格的位置
		int[] pos = new int[clen];
		// 记录空格的数量
		int count = 0;
		// 可以使用Arrays.fill()
		for (int i = 0; i < clen; i++)
			pos[i] = -1;
		// 获得空格数量和位置
		for (int i = 0, j = 0; i < clen; i++)
			if (chs[i] == ' ') {
				count++;
				pos[j++] = i;
			}
		// 没有就返回
		if (count < 1) {
			dst = new String(chs);
			return;
		}
		int LEN = 3;
		// count * (LEN - 1)的意思是去除空格长度，加上%20的长度
		char[] nchs = new char[clen + count * (LEN - 1)];
		// 原来的字符串的指针
		int cursor = 0;
		// 当前是第几个空格
		int current = 0;
		// 新字符串的指针
		int ncursor = 0;
		while (current < count) {
			int pile = pos[current];
			for (int i = cursor; i < pile; i++)
				nchs[ncursor++] = chs[i];
			nchs[ncursor++] = '%';
			nchs[ncursor++] = '2';
			nchs[ncursor++] = '0';
			cursor = pile + 1;
			current++;
		}
		for (int i = cursor; i < clen; i++)
			nchs[ncursor++] = chs[i];
		dst = new String(nchs);
	}

	// 使用JavaAPI，即split再join
	// 注意：如果字符串的最后有空格则结果错误
	private void test2() {
		String[] strs = src.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i]);
			if (i < strs.length - 1)
				sb.append(BLANK);
		}
		dst = sb.toString();
	}

	// 使用JavaAPI，即正则表达式
	private void test1() {
		dst = src.replaceAll(" ", BLANK);
	}

	private void input() {
		try (Scanner in = new Scanner(System.in)) {
			src = in.nextLine();
		}
	}

	private void output() {
		System.out.println("src: " + src);
		System.out.println("dst: " + dst);
	}

	private void init() {
		dst = null;
	}

}
