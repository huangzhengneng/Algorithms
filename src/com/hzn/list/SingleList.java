package com.hzn.list;

/**
 * 
 * @Author: huangzhengneng
 * @Email: zhengnenghuang@gmail.com
 * @Descriotion: 实现单链表，支持增删, int类型
 * @Date:May 20, 2019
 */
public class SingleList {

	/**
	 * @Author: huangzhengneng
	 * @Email: zhengnenghuang@gmail.com
	 * @Descriotion: 节点对象
	 * @Date:May 20, 2019
	 */
	public static class Node {
		public int data;
		public Node next;

		public Node(int value, Node next) {
			data = value;
			this.next = next;
		}
	}

	/**
	 * 头指针节点
	 */
	private Node head = null;
	private int lenght;

	public SingleList(Node head) {
		this.head = head;
		lenght = 1;
	}

	/**
	 * 插入到头结点
	 * 
	 * @param newNode
	 * @return
	 */
	public boolean insertHead(Node newNode) {
		return insert(0, newNode);
	}

	/**
	 * 插入到尾节点
	 * 
	 * @param newNode
	 * @return
	 */
	public boolean insertTail(Node newNode) {
		return insert(lenght - 1, newNode);
	}

	/**
	 * 根据下标插入元素
	 * 
	 * @param index
	 * @param newNode
	 * @return
	 */
	public boolean insert(int index, Node newNode) {
		System.out.println("insert index: " + index);
		if (head == null) {
			System.out.println("head is null");
			if (index > 0) {
				return false;
			}
		}
		if (index == 0) {
			newNode.next = head;
			head = newNode;
			lenght++;
			return true;
		}
		int position = 0;
		Node pre = head;
		while (pre != null) {
			if (position == index) {
				newNode.next = pre.next;
				pre.next = newNode;
				lenght++;
				return true;
			}
			position++;
			pre = pre.next;
		}
		return false;
	}

	/**
	 * 删除头结点
	 * 
	 * @return
	 */
	public boolean deleteHead() {
		return delete(0);
	}

	/**
	 * 删除尾节点
	 * 
	 * @return
	 */
	public boolean deleteTail() {
		return delete(lenght - 1);
	}

	/**
	 * 按下标删除节点
	 * 
	 * @param index
	 * @return
	 */
	public boolean delete(int index) {
		if (head == null) {
			return false;
		}
		if (index == 0) {
			head = head.next;
			lenght--;
			return true;
		}
		int position = 0;
		Node pre = null, curr = head;
		while (curr != null) {
			if (position == index) {
				if (pre != null) {
					pre.next = curr.next;
				} else {
					curr = curr.next;
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

	/**
	 * 按值删除元素，删除的是该值第一次出现的位置
	 * 
	 * @param value
	 * @return
	 */
	public boolean deleteByValue(int value) {
		Node pre = null, curr = head;
		while (curr != null) {
			if (curr.data == value) {
				if (pre == null) {
					head = curr.next;
				} else {
					pre.next = curr.next;
				}
				lenght--;
				return true;
			}
			pre = curr;
			curr = curr.next;
		}
		return false;
	}

	/**
	 * 单链表反转
	 */
	public void reverse() {
		Node pre = null, curr = head;
		while (curr != null) {
			Node next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		head = pre;
	}

	/**
	 * 求链表的中间节点，前提是不知道size
	 * 
	 * 如果size是偶数，返回中间两个节点的平均值，如果是奇数，返回该节点的值
	 * 
	 * 快慢指针法：慢指针一次移动一位，快指针一次移动2位
	 * 
	 * 退出循环，即fast或者fast.next为空
	 * 
	 * fast为空，说明size是偶数。fast.next为空，说明是奇数
	 * 
	 * @return
	 */
	public float getMediumNode() {
		Node low = head, fast = head, pre = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			pre = low;
			low = low.next;
		}
		if (fast == null) {
			// 偶数
			return (pre.data + low.data) / 2.0f;
		} else if (fast.next == null) {
			// 奇数
			return low.data;
		}
		return 0;
	}
	
	/**
	 * 检测单链表是否存在环
	 * 
	 * @return
	 */
	public boolean hasCycle() {
		if (head == null || head.next == null) {
			return false;
		}
		Node low = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			low = low.next;
			if (fast == low) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
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
		SingleList singleList = new SingleList(new Node(1, null));
		singleList.insertHead(new Node(2, null));
		singleList.insertTail(new Node(10, null));
		singleList.insertTail(new Node(6, null));
		singleList.insertTail(new Node(3, null));
		singleList.insertTail(new Node(12, null));
		singleList.insertTail(new Node(10, null));
		singleList.insert(2, new Node(11, null));
		System.out.println(singleList.toString());
		// singleList.deleteByValue(11);
		// System.out.println(singleList.toString());
		singleList.reverse();
		System.out.println(singleList.toString());
		float medium = singleList.getMediumNode();
		System.out.println("medium node value is: " + medium);
		singleList.insertTail(new Node(7, null));
		System.out.println(singleList.toString());
		medium = singleList.getMediumNode();
		System.out.println("medium node value is: " + medium);
	}
}
