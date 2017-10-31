package com.chain.jianzhioffer;

import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * 在一个二维数组中，不存在重复元素，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 查找
 * 
 * @author chain
 *
 */
public class Test01 {

	private int[][] a;

	private int t;

	private boolean res;

	private int px;
	private int py;

	@Test
	public void test() {
		input();

		test1();

		test2();

		test3();
	}

	private void test3() {
		System.out.println(new Solution01().find(t, a));
	}

	// 利用矩形的性质，缩小范围
	private void test2() {
		init();
		int trows = a.length;
		int tcols = a[0].length;
		// 从右上角开始，往左和往下查找，循环往复
		int row = 0;
		int col = a[0].length - 1;
		while (row < trows && col > -1) {
			// 右上角的元素
			if (a[row][col] == t) {
				res = true;
				px = row;
				py = col;
				break;
			} else if (a[row][col] > t) {
				col--;
			} else {
				row++;
			}
		}
		output();
	}

	// 线性做法，从头到尾依次遍历比较
	private void test1() {
		init();
		int trows = a.length;
		int tcols = a[0].length;
		for (int i = 0; i < trows; i++)
			for (int j = 0; j < tcols; j++)
				if (a[i][j] == t) {
					res = true;
					px = i;
					py = j;
					break;
				}
		output();
	}

	private void init() {
		res = false;
		px = -1;
		py = -1;
	}

	private void input() {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			a = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					a[i][j] = in.nextInt();
			t = in.nextInt();
			init();
		}
	}

	private void output() {
		System.out.println(res);
		if (res)
			System.out.println("[" + px + ", " + py + "]");
	}

	class Solution01 {

		// 假定元素是不重复的
		public boolean find(int target, int[][] array) {
			if (array == null)
				return false;
			int trows = array.length;
			int tcols = array[0].length;
			if (trows < 1 || tcols < 1)
				return false;
			int row = 0;
			int col = tcols - 1;
			while (row < trows && col > -1) {
				if (array[row][col] == target)
					return true;
				else if (array[row][col] > target)
					col--;
				else
					row++;
			}
			return false;
		}

	}

}
