package com.xatu.stack;

import java.util.Stack;
/**
 * 用两个栈实现队列操作
 * @author Administrator
 *
 */
public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		} else
			return stack2.pop();

	}
}
