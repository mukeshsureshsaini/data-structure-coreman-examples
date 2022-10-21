package com.alpha.mergek.sortedList;

import java.util.PriorityQueue;

public class MergeKSortedArray {

	public static Node mergeKLists(Node... lists) {

		Node head = new Node();
		Node end = head;

		Node[] nextNode = new Node[lists.length];
		PriorityQueue<ListIdx> pq = new PriorityQueue<>();
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				ListIdx listIdx = new ListIdx(i, lists[i].val);
				pq.add(listIdx);
				nextNode[i] = lists[i];

			}
		}
		while (!pq.isEmpty()) {
			ListIdx min = pq.poll();
			Node data = new Node(min.dataValue);
			end.next = data;
			end = data;
			// in which list we need to fetch next data and update its pointer
			int listIdx = min.listIdx;
			Node list = nextNode[listIdx];
			if (list.next != null) {
				nextNode[listIdx] = list.next;
				int valueData = list.next.val;
				// update its reference
				pq.add(new ListIdx(listIdx, valueData));
				System.out.println("Value data : " + valueData);
			} else {
				nextNode[listIdx] = null;
			}

		}
		return head.next;

	}

	public static void append(Node end, Node data) {

	}

	public static void main(String[] args) {

		Node a1 = Node.build(1, 2, 3);
		// Node.print(a1);

		Node a2 = Node.build(1, 3, 4);
		// Node.print(a2);

		Node a3 = Node.build(2, 6);
		// Node.print(a3);

		Node res = mergeKLists(a1, a2, a3);

		System.out.println("================");
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}

	}

}
