package com.alpha.mergek.sortedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class BST2GreaterTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode convertBST(TreeNode root) {

		TreeNode current = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		int maxTillNow = 0;

		while (stack.isEmpty() || current != null) {
			while (current != null) {
				stack.push(current);
				current = current.right;
			}

			// current is null
			if (!stack.isEmpty()) {
				current = stack.pop();
				current.val = current.val + maxTillNow;
				maxTillNow = current.val;
				current = current.left;
				while (current == null && !stack.isEmpty()) {
					current = stack.pop();
					current.val = current.val + maxTillNow;
					maxTillNow = current.val;
					current = current.left;
				}
			}
		}
		return root;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);

		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);

//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(-1);
//		root.right = new TreeNode(2);
//
//		root.left.left = new TreeNode(-3);
//	
//		root.right.right = new TreeNode(4);
//
		BST2GreaterTree bstGreater = new BST2GreaterTree();
//
		bstGreater.convertBST(root);

	}
}
