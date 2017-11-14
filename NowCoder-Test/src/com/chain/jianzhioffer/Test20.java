package com.chain.jianzhioffer;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序， 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。 （注意：这两个序列的长度是相等的）
 * 
 * 举例让抽象具体化
 * 
 * @author chain
 *
 */
public class Test20 {

	private int[] in;
	private int[] out;
	private boolean r;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		if (in == null || out == null || in.length != out.length)
			return;
		r = fun(in, out);
	}

	private boolean fun(int[] i, int[] o) {
		int posi = 0;
		int poso = 0;
		// i.length==o.length
		int len = i.length;

		LinkedList<Integer> stack = new LinkedList<>();
		while (posi < len && poso < len) {
			stack.push(i[posi++]);
			while (poso < len && o[poso] == stack.peek()) {
				stack.pop();
				poso++;
			}
		}
		return posi == poso;
	}

	private void input() {
		in = new int[] { 1, 2, 3, 4, 5 };
		// out = new int[] { 4, 5, 3, 2, 1 };
		out = new int[] { 4, 5, 3, 1, 2 };
	}

	private void output() {
		System.out.println(r);
	}

	private void init() {
		r = false;
	}
}
