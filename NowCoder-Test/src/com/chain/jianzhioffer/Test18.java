package com.chain.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * 画图让抽象形象化
 * 
 * @author chain
 *
 */
public class Test18 {

	private int[][] m;
	private List<Integer> lst;

	@Test
	public void test() {
		input();

		init();
		test1();
		output();
	}

	private void output() {
		for (int s : lst)
			System.out.print(s + " ");
		System.out.println();
	}

	// 四个标志
	private void test1() {
		int width = m[0].length;
		int height = m.length;
		int top = 0, left = 0, right = width - 1, bottom = height - 1;
		int i;

		while (true) {

			// 左->右
			for (i = left; i <= right; i++)
				lst.add(m[top][i]);

			if (++top > bottom)
				return;

			// 顶->底
			for (i = top; i <= bottom; i++)
				lst.add(m[i][right]);

			if (--right < left)
				return;

			// 右->左
			for (i = right; i >= left; i--)
				lst.add(m[bottom][i]);

			if (--bottom < top)
				return;

			// 底->顶
			for (i = bottom; i >= top; i--)
				lst.add(m[i][left]);

			if (++left > right)
				return;
		}
	}

	private void init() {
		lst = new ArrayList<>();
	}

	private void input() {
		m = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
	}

}
