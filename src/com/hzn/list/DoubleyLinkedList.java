package com.hzn.list;

/**
 * 
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 实现一个双向链表，支持增删操作
 * @Date:2019年5月31日
 */
public class DoubleyLinkedList {

	public static class Node {
		public int data;
		public Node next;
		public Node prev;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node head;
	private int size;

	public DoubleyLinkedList(Node head) {
		this.head = head;
		size = 1;
	}

	/**
	 * 插入元素到頭部
	 * 
	 * @param newNode
	 * @return
	 */
	public boolean insertHead(Node newNode) {
		return insert(0, newNode);
	}

	/**
	 * 插入元素到尾部
	 * 
	 * @param newNode
	 * @return
	 */
	public boolean insertTail(Node newNode) {
		return insert(size, newNode);
	}

	/**
	 * 插入元素，时间复杂度O(n)
	 * 
	 * @param index
	 * @param newNode
	 * @return
	 */
	public boolean insert(int index, Node newNode) {
		if (head == null) {
			System.out.println("head node is null");
			return false;
		}
		if (index > size || index < 0) {
			System.out.println("index is illegal");
			return false;
		}
		int position = 0;
		Node currNode = head, preNode = null;
		while (position <= size) {
			if (position == index) {
				if (currNode != null) {
					newNode.next = currNode;
					currNode.prev = newNode;
				}
				if (preNode != null) {
					preNode.next = newNode;
				}
				newNode.prev = preNode;
				if (position == 0) {
					head = newNode;
				}
				size++;
				return true;
			}
			preNode = currNode;
			currNode = currNode.next;
			position++;
		}
		return false;
	}

	/**
	 * 删除头部元素
	 * 
	 * @return
	 */
	public boolean removeHead() {
		return remove(0);
	}

	/**
	 * 删除尾部元素
	 * 
	 * @return
	 */
	public boolean removeTail() {
		return remove(size - 1);
	}

	/**
	 * 按下标删除元素
	 * 
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {
		if (head == null) {
			System.out.println("head node is null");
			return false;
		}
		if (index > size - 1 || index < 0) {
			System.out.println("index is illegal");
			return false;
		}
		int position = 0;
		Node currNode = head, preNode = null;
		while (position <= size && currNode != null) {
			if (position == index) {
				if (preNode != null) {
					preNode.next = currNode.next;
				} else {
					head = head.next;
				}
				if (currNode.next != null) {
					currNode.next.prev = preNode;
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
	 * 按值删除元素
	 * 
	 * @param data
	 * @return
	 */
	public boolean removeWithData(int data) {
		if (head == null) {
			System.out.println("head node is null");
			return false;
		}
		int position = 0;
		Node currNode = head, preNode = null;
		while (position <= size && currNode != null) {
			if (currNode.data == data) {
				if (preNode != null) {
					preNode.next = currNode.next;
				} else {
					head = head.next;
				}
				if (currNode.next != null) {
					currNode.next.prev = preNode;
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

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("head: ");
		Node currNode = head;
		while (currNode != null && currNode.next != null) {
			sBuilder.append(currNode.data);
			currNode = currNode.next;
			if (currNode != null) {
				sBuilder.append(" ---->  ");
			}
		}
		sBuilder.append(currNode.data);
		sBuilder.append("\n");
		sBuilder.append("tail: ");
		while (currNode != null) {
			sBuilder.append(currNode.data);
			currNode = currNode.prev;
			if (currNode != null) {
				sBuilder.append(" ---> ");
			}
		}
		sBuilder.append(".");
		return sBuilder.toString();
	}

	public static void main(String[] args) {
		DoubleyLinkedList linkedList = new DoubleyLinkedList(new Node(10));
		linkedList.insertHead(new Node(5));
		linkedList.insertTail(new Node(15));
		System.out.println(linkedList.toString());
		linkedList.insert(1, new Node(7));
		linkedList.insert(1, new Node(6));
		linkedList.insert(3, new Node(8));
		System.out.println(linkedList.toString());
		linkedList.remove(1);
		System.out.println(linkedList.toString());
//		linkedList.removeWithData(7);
		linkedList.removeHead();
		System.out.println(linkedList.toString());
		linkedList.removeTail();
		System.out.println(linkedList.toString());
	}
}
