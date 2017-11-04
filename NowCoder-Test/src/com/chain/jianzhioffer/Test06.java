package com.chain.jianzhioffer;

import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 8输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * 查找
 * 
 * @author chain
 *
 */
public class Test06 {

	private int n;
	private int[] a;

	private int t;

	@Test
	public void test() {
		intput();

		init();
		test1();
		output();

		init();
		test2();
		output();

		System.out.println(new Solution06().minNumberInRotateArray(a));
	}

	// 线性查找，即查找最小值
	private void test1() {
		int min = a[0];
		for (int i = 1; i < n; i++)
			if (a[i] < min)
				min = a[i];
		t = min;
	}

	// 利用二分查找原理，特殊情况如11101使用线性查找
	private void test2() {
		// 利用旋转的性质
		int left = 0;
		int right = n - 1;
		while (a[left] >= a[right]) {
			int mid = (right - left) / 2 + left;

			// 如果left,right,mid都相同，则无法判断，只能采用线性查找
			if (a[left] == a[right] && a[right] == a[mid]) {
				test1();
				return;
			}

			if (left + 1 == right) {
				t = a[right];
				return;
			}

			if (a[mid] >= a[left])
				left = mid;
			else if (a[mid] <= a[right])
				right = mid;
		}
	}

	private void intput() {
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			if (n < 1)
				return;
			a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = in.nextInt();
		}
	}

	private void output() {
		System.out.println(t);
	}

	private void init() {
		t = -1;
	}

	class Solution06 {

		public int minNumberInRotateArray(int[] array) {
			int[] a = array;
			if (a == null || a.length < 1)
				throw new RuntimeException("array should not be null or empty");

			int n = a.length;
			// 利用旋转的性质
			int left = 0;
			int right = n - 1;
			while (a[left] >= a[right]) {
				int mid = (right - left) / 2 + left;

				// 如果left,right,mid都相同，则无法判断，只能采用线性查找
				if (a[left] == a[right] && a[right] == a[mid]) {
					int min = a[0];
					for (int i = 1; i < n; i++)
						if (a[i] < min)
							min = a[i];
					return min;
				}

				if (left + 1 == right)
					break;

				if (a[mid] >= a[left])
					left = mid;
				else if (a[mid] <= a[right])
					right = mid;
			}
			return a[right];
		}
	}

}
