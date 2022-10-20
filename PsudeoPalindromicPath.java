import java.util.ArrayDeque;
import java.util.Deque;

public class PsudeoPalindromicPath {
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

		@Override
		public String toString() {
			return "" + val;
		}
	}

	public static int pseudoPalindromicPaths(TreeNode root) {

		int[] frequencies = new int[10];
		int counter = 0;

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode current = root;

		while (!stack.isEmpty() || current != null) {

			while (current != null) {
				stack.push(current);
				frequencies[current.val] += 1;
				current = current.left;
			}

			System.out.println(stack);
			if (!stack.isEmpty()) {
				current = stack.peek().right;
				if (current == null) { // we found the leaf
					stack.pop(); // remove the leaf
					if (!stack.isEmpty())
						current = stack.peek().right;
				}
			}

		}
		return counter;
	}

	public static boolean isPalindrome(int[] f) {

		int oddCounter = 0;
		int totalCount = 0;
		for (int i = 0; i < f.length; i++) {
			if (f[i] > 0) {
				totalCount += f[i];
				if (f[i] % 2 != 0)
					oddCounter++;
			}
		}

		if (totalCount % 2 == 0)
			return oddCounter == 0;
		else
			return oddCounter == 1;

	}

	public static boolean isLeaf(TreeNode node) {
		boolean isLeaf = node.left == null && node.right == null;
		return isLeaf;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);

		System.out.println(pseudoPalindromicPaths(root));

		// [2,1,1,1,3,null,null,null,null,null,1]

//		TreeNode root2 = new TreeNode(2);
//		root2.left = new TreeNode(1);
//		root2.right = new TreeNode(1);
//
//		root2.left.left = new TreeNode(1);
//		root2.left.right = new TreeNode(3);
//
//		root2.left.right.right = new TreeNode(1);
//
//		System.out.println(pseudoPalindromicPaths(root2));
	}

}
