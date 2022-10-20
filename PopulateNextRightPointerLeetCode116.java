import java.util.LinkedList;
import java.util.Queue;

//Leetcode 116

/**
 * 
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following
 * definition:
 * 
 * struct Node { int val; Node *left; Node *right; Node *next; } Populate each
 * next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 *
 */
public class PopulateNextRightPointerLeetCode116 {

	// Definition for a Node.
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	/**
	 * method for perfect binary tree
	 * 
	 * @param root
	 * @return
	 */
	public Node connect(Node root) {

		if (root == null)
			return root;
		if (root.left == null) { // since it is perfect tree we dont need root.right check
			root.next = null;
			return root;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			q.add(null); // end of previous level
			while (!q.isEmpty() && q.peek() != null) { // process this level and add next level
				Node ele = q.poll();
				ele.next = q.peek();
				if (ele.left != null) { // perfect binay tree no need to root.right check
					q.add(ele.left);
					q.add(ele.right);
				}
			}
			q.poll(); // while loop will be terminated because of null head hence remove it

		}
		return root;
	}

	/**
	 * method for genral binary tree
	 * 
	 * @param root
	 * @return
	 */
	public Node connectNonPerfectBinaryTee(Node root) {
		if (root == null)
			return root;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			q.add(null); // end of previous level

			while (!q.isEmpty() && q.peek() != null) { // process this level and append queue with next level

				Node element = q.poll();
				element.next = q.peek();
				if (element.left != null)
					q.add(element.left);
				if (element.right != null)
					q.add(element.right);

			} // this loop will be terminated because of queue first element is null hence
				// remove it
			q.poll(); // remove null head

		}
		return root;

	}
}
