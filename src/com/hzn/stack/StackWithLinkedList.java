package com.hzn.stack;

import java.util.Random;

/**
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 用链表实现一个链式栈
 * @Date:2019年6月27日
 */
public class StackWithLinkedList {

	public class Node {
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	private Node headNode;
	private int mSize;
	private int mMaxSize;
	
	public StackWithLinkedList(int capacity) {
		mMaxSize = capacity;
		mSize = 0;
	}
	
	public void push(int element) {
		if (mSize >= mMaxSize) {
			throw new IllegalStateException("stack is full...");
		}
		Node node = new Node(element);
		node.next = headNode;
		headNode = node;
		mSize++;
	}
	
	public int pop() {
		if (mSize == 0) {
			throw new IllegalStateException("stack is empty...");
		}
		int result = headNode.val;
		headNode = headNode.next;
		mSize--;
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		Node node = headNode;
		for(int i = 0; i < mSize; i++) {
			stringBuilder.append(node.val);
			if (i < mSize - 1) {
				stringBuilder.append(",");
			}
			node = node.next;
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		StackWithLinkedList stack = new StackWithLinkedList(10);
		Random random = new Random();
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
		System.out.println(stack.toString());
		stack.push(random.nextInt(100));
	}
}
