package com.hzn.stack;

import java.util.Random;

/**
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 用数组实现一个顺序栈
 * @Date:2019年6月27日
 */
public class StackWithArray {

	private final int EMPTY = Integer.MAX_VALUE;
	
	private int[] mArray;
	private int mSize;
	private int mTopElementIndex = 0;
	
	public StackWithArray(int capacity) {
		mArray = new int[capacity];
		mSize = 0;
		for (int i = 0; i < mArray.length; i++) {
			mArray[i] = EMPTY;
		}
	}
	
	public void push(int element) {
		if (mSize >= mArray.length) {
			throw new IllegalStateException("栈空间已满...");
		}
		if (mTopElementIndex > mArray.length - 1) {
			// 超出范围了，需要移动元素使最底下的元素到数组下标0的位置
			moveElements();
		}
		mArray[mTopElementIndex++] = element;
		mSize++;
	}
	
	private void moveElements() {
		System.out.println("moving elements...");
		for(int i = 0; i < mSize; i++) {
			mArray[i] = mArray[mTopElementIndex - mSize + i];
			mArray[mTopElementIndex - mSize + i] = EMPTY;
		}
		mTopElementIndex = mSize - 1;
	}
	
	public int pop() {
		if (mSize == 0) {
			throw new IllegalStateException("栈为空...");
		}
		int result = mArray[mTopElementIndex];
		mArray[mTopElementIndex--] = EMPTY;
		mSize--;
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for(int i = 0; i < mSize; i++) {
			stringBuilder.append(mArray[mTopElementIndex - mSize + i]);
			if (i < mSize - 1) {
				stringBuilder.append(",");
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		StackWithArray stack = new StackWithArray(10);
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
	}
}
