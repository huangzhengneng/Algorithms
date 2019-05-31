package com.hzn.list;

/**
 * 
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 实现有序单链表，并且实现两个有序链表的合并
 * @Date:2019年5月31日
 */
public class SortedLinkedList {

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node head;
	private int size;

	public SortedLinkedList(Node head) {
		this.head = head;
		size = 1;
	}

	/**
	 * 插入元素
	 * 
	 * @param data
	 * @return
	 */
	public boolean insert(int data) {
		if (head == null) {
			head = new Node(data);
			size++;
			return true;
		}
		Node newNode = new Node(data);
		Node currNode = head, preNode = null;
		while (currNode != null) {
			if (currNode.data > data) {
				newNode.next = currNode;
				if (preNode == null) {
					head = newNode;
				} else {
					preNode.next = newNode;
				}
				size++;
				return true;
			}
			preNode = currNode;
			currNode = currNode.next;
		}
		preNode.next = newNode;
		size++;
		return true;
	}

	/**
	 * 根据下标删除元素
	 * 
	 * @param index
	 * @return
	 */
	public boolean removeWithIndex(int index) {
		if (head == null) {
			System.out.println("head is null");
			return false;
		}
		if (index < 0 || index >= size) {
			System.out.println("index is illegal");
			return false;
		}
		int position = 0;
		Node currNode = head, preNode = null;
		while (position < size && currNode != null) {
			if (position == index) {
				if (preNode == null) {
					head = head.next;
				} else {
					preNode.next = currNode.next;
				}
				size--;
				return true;
			}
			preNode = currNode;
			currNode = currNode.next;
			position++;
		}
		return false;
	}

	/**
	 * 根据值删除元素
	 * 
	 * @param data
	 * @return
	 */
	public boolean removeWithData(int data) {
		if (head == null) {
			System.out.println("head is null");
			return false;
		}
		Node currNode = head, preNode = null;
		while (currNode != null) {
			if (currNode.data == data) {
				if (preNode == null) {
					head = head.next;
				} else {
					preNode.next = currNode.next;
				}
				size--;
				return true;
			}
			preNode = currNode;
			currNode = currNode.next;
		}
		return false;
	}

	/**
	 * 合并两个有序链表
	 * 
	 * @param headNode
	 * @param mergeSize
	 */
	public SortedLinkedList merge(Node headNode, int mergeSize) {
		SortedLinkedList sortedLinkedList = null;
		if (headNode != null) {
			if (head == null) {
				sortedLinkedList = new SortedLinkedList(headNode);
				sortedLinkedList.size = mergeSize;
			} else {
				Node n1 = head, n2 = headNode;
				Node newHeadNode = null, newHeadNodes = null;
				while (n1 != null && n2 != null) {
					if (n1.data <= n2.data) {
						if (newHeadNode == null) {
							newHeadNode = new Node(n1.data);
							newHeadNodes = newHeadNode;
						} else {
							newHeadNode.next = new Node(n1.data);
							newHeadNode = newHeadNode.next;
						}
						n1 = n1.next;
					} else {
						if (newHeadNode == null) {
							newHeadNode = new Node(n2.data);
							newHeadNodes = newHeadNode;
						} else {
							newHeadNode.next = new Node(n2.data);
							newHeadNode = newHeadNode.next;
						}
						n2 = n2.next;
					}
				}
				if (n1 != null) {
					newHeadNode.next = n1;
				} else if (n2 != null) {
					newHeadNode.next = n2;
				}
				sortedLinkedList = new SortedLinkedList(newHeadNodes);
				sortedLinkedList.size = size + mergeSize;
			}
		}
		return sortedLinkedList;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size: ").append(size).append("     ");
		stringBuilder.append("list: ");
		Node headNode = head;
		while (headNode != null) {
			stringBuilder.append(headNode.data);
			headNode = headNode.next;
			if (headNode != null) {
				stringBuilder.append(" ---> ");
			}
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		SortedLinkedList linkedList = new SortedLinkedList(new Node(5));
		linkedList.insert(10);
		linkedList.insert(4);
		linkedList.insert(7);
		linkedList.insert(11);
		System.out.println(linkedList.toString());
//		linkedList.removeWithData(5);
//		System.out.println(linkedList.toString());
//		linkedList.removeWithIndex(4);
//		System.out.println(linkedList.toString());

		SortedLinkedList linkedList2 = new SortedLinkedList(new Node(3));
		linkedList2.insert(12);
		linkedList2.insert(6);
		linkedList2.insert(7);
		linkedList2.insert(2);
		System.out.println(linkedList2.toString());

		SortedLinkedList sortedLinkedList = linkedList.merge(linkedList2.head, linkedList2.size);
		System.out.println(sortedLinkedList == null ? "result is null" : sortedLinkedList.toString());
	}
}
