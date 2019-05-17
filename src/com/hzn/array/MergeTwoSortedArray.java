package com.hzn.array;

/**
 * 
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 实现两个有序数组，合并为一个有序数组
 * @Date:2019年5月17日
 */
public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 2, 4, 6, 8, 34 };
		int[] arr2 = { 1, 2, 5, 33, 35 };
		int[] mergedArr = merge(arr1, arr2);
		print(mergedArr);
	}

	/**
	 * 合并两个有序数组
	 * 
	 * n表示第一个数组的长度 m表示第二个数组的长度 时间复杂度：O(n + m) 空间复杂度：O(n + m)
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private static int[] merge(int[] arr1, int[] arr2) {
		if (isEmptyArray(arr1)) {
			return arr2;
		}
		if (isEmptyArray(arr2)) {
			return arr1;
		}
		int index = 0, i = 0, j = 0, n = arr1.length, m = arr2.length;
		int[] result = new int[n + m];
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				result[index++] = arr1[i++];
			} else {
				result[index++] = arr2[j++];
			}
		}
		while (i < n) {
			result[index++] = arr1[i++];
		}
		while (j < m) {
			result[index++] = arr2[j++];
		}
		return result;
	}

	private static boolean isEmptyArray(int[] arr) {
		return arr == null || arr.length == 0;
	}

	public static void print(int[] arr) {
		if (arr == null) {
			System.out.println("arr is null");
		}
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[");
		for (int i = 0, len = arr.length; i < len; i++) {
			sBuilder.append(arr[i]);
			if (i < len - 1) {
				sBuilder.append(",");
			}
		}
		sBuilder.append("]");
		System.out.println(sBuilder.toString());
		;
	}
}
