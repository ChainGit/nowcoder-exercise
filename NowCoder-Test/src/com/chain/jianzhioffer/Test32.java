package com.chain.jianzhioffer;

import org.junit.Test;

/**
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 类型：时间效率
 * 
 * 书中：42
 * 
 * @author chain
 *
 */
public class Test32 {

	private int[] a;
	private String r;

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

	private String fun(int[] numbers) {
		int[] a = numbers;
		// 如果是一个接口（供别人使用的）那么需要做好边值检测和安全防御
		// 如果是内部方法，为了减少臃肿和加快速度，可以不做太多的检测
		if (a == null || a.length < 1)
			// 牛客网中返回的值如果是错误的，则返回“空”（内容为空）
			return "";
		int len = a.length;
		byte[][] c = convert(a);
		// 按特殊规则排序
		// 这里为选择排序（可以优化成快速排序）
		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++)
				if (compare(c[min], c[j]) > 0)
					min = j;
			if (min != i) {
				byte[] t = c[min];
				c[min] = c[i];
				c[i] = t;
			}
		}
		return stringify(c);
	}

	private String stringify(byte[][] c) {
		int len = c.length;
		int t = 0;
		for (int i = 0; i < len; i++)
			t += c[i].length;
		byte[] r = new byte[t];
		for (int i = 0, j = 0; i < len; i++)
			for (int k = 0; k < c[i].length; k++)
				r[j++] = (byte) (c[i][k] + '0');
		return new String(r);
	}

	private byte[][] convert(int[] a) {
		int len = a.length;
		byte[][] r = new byte[len][];
		for (int i = 0; i < len; i++)
			r[i] = n2a(a[i]);
		return r;
	}

	private byte[] n2a(int n) {
		int t = n;
		int p = 1;
		while ((t /= 10) != 0)
			p++;
		byte[] r = new byte[p--];
		while (n != 0) {
			t = n % 10;
			r[p--] = (byte) (t & 0xff);
			n /= 10;
		}
		return r;
	}

	// 需要满足自反性、对称性、传递性
	private int compare(byte[] a, byte[] b) {
		int lt = a.length + b.length;
		for (int i = 0; i < lt; i++) {
			byte x = get(a, b, true, i);
			byte y = get(a, b, false, i);
			if (x > y)
				return 1;
			else if (x < y)
				return -1;
		}
		return 0;
	}

	private byte get(byte[] a, byte[] b, boolean k, int i) {
		int la = a.length;
		int lb = b.length;
		byte r = 0;
		// a+b
		if (k)
			r = i < la ? a[i] : b[i - la];
		// b+a
		else
			r = i < lb ? b[i] : a[i - lb];
		return r;
	}

	private void input() {
		a = new int[] { 3, 32, 321 };
	}

	private void output() {
		System.out.println(r);
	}

	private void init() {

	}

}
