package com.hzn.list;

/**
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 实现一个单向循环链表，支持增删操作
 * @Date:May 22, 2019
 */
public class CircularLinkedList {

	/**
	 * @Author: huangzhengneng
	 * @Email: zhengnenghuang@gmail.com
	 * @Descriotion: 链表节点，int类型
	 * @Date:May 22, 2019
	 */
	public static class Node {
		public int data;
		public Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private int lenght;

	public CircularLinkedList(Node head) {
		this.head = head;
		this.head.next = head;
		lenght = 1;
	}

	/**
	 * 根据下标插入元素，实现跟单链表一样,时间复杂度O(n)
	 * 
	 * @param index
	 * @param newNode
	 * @return
	 */
	public boolean insert(int index, Node newNode) {
		if (head == null) {
			System.out.println("head is null");
			return false;
		}
		int position = 0;
		Node curr = head;
		boolean[] visit = new boolean[lenght];
		while (position < lenght && !visit[position]) {
			visit[position] = true;
			if (index == position) {
				newNode.next = curr.next;
				curr.next = newNode;
				lenght++;
				return true;
			}
			position++;
			curr = curr.next;
		}
		return false;
	}

	/**
	 * 插入元素到链头
	 * 
	 * @param newNode
	 * @return
	 */
	public boolean insertHead(Node newNode) {
		return insert(0, newNode);
	}

	/**
	 * 插入元素到链尾
	 * 
	 * @param newNode
	 * @return
	 */
	public boolean insertTail(Node newNode) {
		return insert(lenght - 1, newNode);
	}

	/**
	 * 根据下标删除元素，和单链表实现方式一致,时间复杂度O(n)
	 * 
	 * @param index
	 * @return
	 */
	public boolean delete(int index) {
		if (head == null) {
			System.out.println("head is null");
			return false;
		}
		int position = 0;
		Node curr = head, pre = null;
		boolean[] visit = new boolean[lenght];
		while (position < lenght && !visit[position]) {
			if (position == index) {
				if (position == 0) {
					// 删除头结点，需要先遍历一遍找到next指向头结点的节点
					Node tail = head;
					while (tail.next != head) {
						tail = tail.next;
					}
					tail.next = curr.next;
					curr.next = null;
				} else {
					pre.next = curr.next;
					curr.next = null;
				}
				lenght--;
				return true;
			}
			position++;
			pre = curr;
			curr = curr.next;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("list: ");
		Node curr = head;
		boolean[] visit = new boolean[lenght];
		int position = 0;
		while (position < lenght && !visit[position]) {
			sBuilder.append(curr.data);
			curr = curr.next;
			position++;
			if (curr != null) {
				sBuilder.append(" ---> ");
			}
		}
		return sBuilder.toString();
	}

	public static void main(String[] args) {
		CircularLinkedList linkedList = new CircularLinkedList(new Node(1, null));
		linkedList.insertHead(new Node(5, null));
		linkedList.insertTail(new Node(10, null));
		linkedList.insert(1, new Node(15, null));
		System.out.println(linkedList.toString());
		linkedList.delete(2);
		System.out.println(linkedList.toString());
	}
}
