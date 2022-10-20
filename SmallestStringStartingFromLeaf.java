
public class SmallestStringStartingFromLeaf {

	String res;


	public String smallestFromLeaf(TreeNode root) {

		TreeNode current = root;
		StringBuilder sb = new StringBuilder();
		while (current != null) {
			sb.append((char) current.val);
			current = current.left;
		}
		res = sb.reverse().toString();
		dfs(root, new StringBuilder());
		return res;
	}

	public void dfs(TreeNode node, StringBuilder prefix) {
		if (node == null)
			return;
		prefix.append((char) node.val);
		prefix.reverse();
		String S = prefix.toString();
		prefix.reverse();
		if (node.left == null && node.right == null) { // at leaf
			if (S.compareTo(res) < 0) {// find a smaller sum
				res = S;
			}
		}
		if (node.left != null)
			dfs(node.left, prefix);
		if (node.right != null)
			dfs(node.right, prefix);

		prefix.deleteCharAt(prefix.length() - 1);
	}


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

	public static void main(String[] args) {

//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//
//		root.right.left = new TreeNode(3);
//		root.right.right = new TreeNode(4);
//
//		System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(root));

		 TreeNode root = new TreeNode('z');
		root.left = new TreeNode('b');
		root.right = new TreeNode('d');
		root.left.left = new TreeNode('b');
		root.left.right = new TreeNode('d');

		root.right.left = new TreeNode('a');
		root.right.right = new TreeNode('c');

		System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(root));

	}
}
