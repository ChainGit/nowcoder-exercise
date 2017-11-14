package com.chain.jianzhioffer;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * 举例让抽象具体化
 * 
 * @author chain
 *
 */
public class Test19 {

	@Test
	public void test() {
		Stack stack = new Stack();
		stack.push(4);
		stack.push(5);
		stack.push(4);
		stack.push(1);
		stack.push(0);
		stack.push(9);

		System.out.println(stack.top());
		System.out.println(stack.min());

		stack.pop();

		System.out.println(stack.top());
		System.out.println(stack.min());

		stack.pop();

		System.out.println(stack.top());
		System.out.println(stack.min());
	}

	class Stack {

		private LinkedList<Integer> stack = new LinkedList<>();
		private LinkedList<Integer> help = new LinkedList<>();

		public void push(int node) {
			stack.push(node);
			if (help.isEmpty() || help.peek() > node)
				help.push(node);
			else
				help.push(help.peek());
		}

		public void pop() {
			help.poll();
			stack.poll();
		}

		public int top() {
			return stack.peek();
		}

		public int min() {
			return help.peek();
		}
	}
}
