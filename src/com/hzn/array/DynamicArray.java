package com.hzn.array;

/**
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 设计一个支持动态扩容的数组
 * @Date:May 17, 2019
 */
public class DynamicArray<T extends Object> {

	/**
	 * 默认初始化大小
	 */
	private static final int DEFAULT_CAPACITY = 16;

	private T[] elements;
	private int size;

	public DynamicArray(int capacity) {
		elements = (T[]) new Object[capacity];
		size = 0;
	}

	public DynamicArray() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 根据下标获取元素
	 * 
	 * @param index
	 *            下标
	 * @return 返回下标对应的元素，若对应位置没有元素，则返回空
	 * @throws IndexOutOfBoundsException
	 *             index超出范围时抛出
	 */
	public T get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(String.format("访问下标越界，请使用正确的下标访问，当前数组容量为：%d", elements.length));
		}
		return elements[index];
	}

	public boolean update(int index, T e) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(String.format("访问下标越界，请使用正确的下标访问，当前数组容量为：%d", elements.length));
		}
		elements[index] = e;
		return true;
	}

	/**
	 * 根据下标移除元素，若移除之后size太小，需要进行缩容
	 * 
	 * @param index
	 * @return
	 */
	public T remove(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(String.format("访问下标越界，请使用正确的下标访问，当前数组容量为：%d", elements.length));
		}
		T result = elements[index];
		// 把index之后的数据往前移动一位,O(n)
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		size--;

		// 缩容
		if (size < elements.length / 4) {
			resize(elements.length / 2);
		}

		return result;
	}

	public boolean add(T e) {
		return add(size, e);
	}

	/**
	 * 添加元素到对应的位置，原数据往后移动
	 * 
	 * @param index
	 * @param e
	 * @return
	 */
	public boolean add(int index, T e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("添加元素下标异常");
		}
		if (size >= elements.length) {
			// 需要扩容
			resize(elements.length * 2);
		}
		// 把对应index以及其之后的元素全部向后移一位，O(n)时间复杂度
		for (int i = size; i > index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = e;
		size++;
		return true;
	}

	/**
	 * 扩容数组长度至原数组的两倍
	 */
	private void resize(int newSize) {
		System.out.println(String.format("即将变化容量，当前容量：%d, 新容量：%d", elements.length, newSize));
		T[] tmp = (T[]) new Object[newSize];
		System.arraycopy(elements, 0, tmp, 0, size);
		elements = tmp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(elements[i]);
			if (i < size - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DynamicArray<Integer> da = new DynamicArray<>(5);
		da.add(1);
		da.add(5);
		da.add(12);
		da.add(23432);
		da.add(123);
		da.add(2, 77);
		da.remove(1);
		da.remove(1);
		da.remove(1);
		da.remove(1);
		da.remove(1);
		System.out.println(da.toString());
	}
}
