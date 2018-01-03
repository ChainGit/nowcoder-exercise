package com.chain.jianzhioffer;

import java.util.Arrays;

import org.junit.Test;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 
 * @author chain
 *
 */
public class Test29 {

	private int[] a;
	private int k;

	private int[] r;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void test1() {
		r = fun(a, k);
	}

	// 新建一个容器，利用插入排序的方法
	private int[] fun(int[] input, int k) {

		return null;
	}

	private void input() {
		a = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
		k = 4;
	}

	private void output() {
		System.out.println(Arrays.asList(r));
	}

	private void init() {

	}
}
