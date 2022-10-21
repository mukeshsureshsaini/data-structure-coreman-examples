package com.alpha.mergek.sortedList;

public class BinaryKthSmallestElement {

	//TO-DO
	public int kthSmallest(TreeNode root, int k) {

		return 0;
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root != null && root.right == null && root.left == null)
			return true;
		if (root.left != null && (root.val < root.left.val))
			return false;
		if (root.right != null && (root.val > root.right.val))
			return false;
		if (root.left == null && root.right != null && root.right.val > root.val) {
			return isValidBST(root.right);
		} else if (root.right == null && root.left != null && root.left.val < root.val) {
			return isValidBST(root.left);
		} else if (root.left != null && root.right != null && root.left.val < root.val && root.right.val > root.val) {
			return isValidBST(root.left) && isValidBST(root.right);
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);

		BinaryKthSmallestElement b = new BinaryKthSmallestElement();

		System.out.println(b.isValidBST(root));

	}

}

class TreeNode {
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