package com.hzn.array;

/**
 * 
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 实现一个大小固定的有序数组，支持增删改操作
 * @Date:2019年5月17日
 */
public class SortedArray {

	private static final int DEFAULT_CAPACITY = 16;

	private int[] elements;
	private int size;

	public SortedArray(int capacity) {
		elements = new int[capacity];
		size = 0;
	}

	public SortedArray() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 添加元素，自动添加到对应的位置，添加完成之后数组还是有序
	 * 
	 * @param element
	 * @return
	 */
	public boolean add(int element) {
		if (size >= elements.length) {
			System.out.println("数组已经满了");
			return false;
		}
		if (size == 0) {
			elements[0] = element;
			size++;
			return true;
		}
		// 倒序遍历已有数据，把大于目标值得元素全部往后移一位
		// 直到找到小于等于目标值的元素，没找到就添加到数组开始位置
		boolean flag = false;
		for (int i = size - 1; i >= 0; i--) {
			int curr = elements[i];
			if (curr <= element) {
				elements[i + 1] = element;
				flag = true;
				break;
			} else {
				elements[i + 1] = curr;
			}
		}
		if (!flag) {
			elements[0] = element;
		}
		size++;
		return true;
	}

	/**
	 * 按下标移除对应元素
	 * 
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {
		if (index < 0 || index > size - 1) {
			System.out.println("下标异常");
			return false;
		}
		for (int i = index; i < size; i++) {
			elements[i] = elements[i + 1];
		}
		elements[size] = 0;
		size--;
		return true;
	}

	/**
	 * 按下标更新元素
	 * 
	 * @param index
	 * @param newElement
	 * @return
	 */
	public boolean set(int index, int newElement) {
		if (index < 0 || index > size - 1) {
			System.out.println("下标异常");
			return false;
		}
		elements[index] = newElement;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[");
		for (int i = 0; i < size; i++) {
			sBuilder.append(elements[i]);
			if(i < size - 1) {
				sBuilder.append(",");
			}
		}
		sBuilder.append("]");
		return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		SortedArray sortedArray = new SortedArray(7);
		sortedArray.add(5);
		sortedArray.add(3);
		sortedArray.add(0);
		sortedArray.add(12);
		sortedArray.add(33);
		sortedArray.add(3);
		sortedArray.add(6);
		sortedArray.add(15);
		sortedArray.add(44);
		sortedArray.add(99);
		sortedArray.add(43);
		sortedArray.add(22);
		sortedArray.add(14);
		sortedArray.add(12);
		sortedArray.add(7);
		sortedArray.remove(10);
		System.out.println(sortedArray.toString());
		sortedArray.set(5, 10);
		System.out.println(sortedArray.toString());
	}
}
