package com.chain.jianzhioffer;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 栈、队列
 * 
 * @author chain
 *
 */
public class Test05 {

	class Queue {
		private LinkedList<Integer> stack1 = new LinkedList<>();
		private LinkedList<Integer> stack2 = new LinkedList<>();

		// 这里可以使用count方便操作
		// private int count;

		public Integer pull() {
			if (!stack2.isEmpty()) {
				return stack2.pop();
			} else {
				while (!stack1.isEmpty())
					stack2.push(stack1.pop());

				if (!stack2.isEmpty())
					return stack2.pop();
			}
			return null;
		}

		public void add(Integer e) {
			stack1.push(e);
		}
	}

	@Test
	public void test() {
		test1();

		test2();
	}

	private void test1() {
		Queue queue = new Queue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		queue.add(4);
		System.out.println(queue.pull());
		queue.add(5);
		System.out.println(queue.pull());
		System.out.println(queue.pull());
	}

	private void test2() {
		Solution05 queue = new Solution05();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.push(4);
		System.out.println(queue.pop());
		queue.push(5);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}

	class Solution05 {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			if (!stack2.isEmpty()) {
				return stack2.pop();
			} else {
				while (!stack1.isEmpty())
					stack2.push(stack1.pop());

				return stack2.pop();
			}
		}
	}

}
