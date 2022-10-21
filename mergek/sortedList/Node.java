package com.alpha.mergek.sortedList;

public class Node {
	int val;
	Node next;

	Node() {
	}

	Node(int val) {
		this.val = val;
	}

	Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "[" + val + "]";
	}

	public static Node build(int... arr) {
		Node head = new Node();
		Node end = head;
		for (int x : arr) {
			Node newNode = new Node(x);
			end.next = newNode;
			end = newNode;
		}
		
		return head.next;
	}
	
	public static void print(Node head) {
		Node end = head;
		while(end!=null) {
			System.out.println(end.val);
			end = end.next;
		}
	}
}
