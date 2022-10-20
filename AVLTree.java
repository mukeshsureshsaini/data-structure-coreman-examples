
class AVLNode {

	int data;
	int height;
	AVLNode left;
	AVLNode right;

	public AVLNode(int data) {
		this.data = data;
	}
}

public class AVLTree {

	private AVLNode root;

	public AVLNode insert(int data) {
		return insert(root, data);
	}

	private AVLNode insert(AVLNode root, int data) {
		if (root == null) {
			AVLNode n = new AVLNode(data);
			return n;
		} else if (data < root.data) {
			root.left = insert(root.left, data);
			int balanceFactor = balanceFactor(root);
			if (balanceFactor > 1) { // data went on left side

				if (data < root.left.data) { // left of left
					return rightRotate(root);
				} else { // right of left
					root.left = rightRotate(root.left);
					return leftRotate(root);
				}

			}

		} else if (data > root.data) {
			root.right = insert(root.right, data);
			int balanceFactor = balanceFactor(root);
			if (balanceFactor < -1) { // data went or right side
				if (data > root.right.data) { // right of right
					return leftRotate(root);
				} else { // left of right
					root.right = rightRotate(root.right);
					return rightRotate(root);
				}
			}
		} else { // value is equal ,no need to insert it
			return root;
		}

		updateHeight(root);
		return root;

	}

	private int balanceFactor(AVLNode node) {
		if (node == null || (node.left == null && node.right == null))
			return 0;
		else if (node.left != null && node.right != null)
			return node.left.height - node.right.height;
		else if (node.left == null)
			return -node.right.height;
		else
			return node.left.height;
	}

	private void updateHeight(AVLNode node) {
		if (node == null || (node.left == null && node.right == null)) {

		} else if (node.left != null && node.right != null)
			node.height = Math.max(node.left.height, node.right.height) + 1;
		else if (node.left == null)
			node.height = node.right.height + 1;
		else
			node.height = node.left.height + 1;
	}

	private AVLNode leftRotate(AVLNode pivotNode) {
		AVLNode newPivot = pivotNode.right;
		pivotNode.right = newPivot.left;
		newPivot.left = pivotNode;
		updateHeight(pivotNode);
		updateHeight(newPivot);
		return newPivot;
	}

	private AVLNode rightRotate(AVLNode pivotNode) {
		AVLNode newPivot = pivotNode.left;
		pivotNode.left = newPivot.right;
		newPivot.right = pivotNode;
		updateHeight(pivotNode);
		updateHeight(newPivot);

		return newPivot;
	}
}
