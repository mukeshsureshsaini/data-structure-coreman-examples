import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tree {

	private TreeNode root;
	private List<Integer> eulerPath;
	private List<Integer> eulerPathOfDepth;
	private int[] firstOccurenceInEulerPath;

	public int[] getFirstOccurenceInEulerPath() {
		return firstOccurenceInEulerPath;
	}

	public void setFirstOccurenceInEulerPath(int[] firstOccurenceInEulerPath) {
		this.firstOccurenceInEulerPath = firstOccurenceInEulerPath;
	}

	private int size;

	public List<Integer> getEulerPathOfDepth() {
		return eulerPathOfDepth;
	}

	public void setEulerPathOfDepth(List<Integer> eulerPathOfDepth) {
		this.eulerPathOfDepth = eulerPathOfDepth;
	}

	public Tree(TreeNode root) {
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public List<Integer> eulerPath() {
		eulerPath = new ArrayList<>();
		eulerPath.add(-1);
		eulerPathOfDepth = new ArrayList<>();
		eulerPathOfDepth.add(-1);
		eulerPath(root);

		firstOccurenceInEulerPath = new int[this.getSize() + 1];
		firstOccurenceInEulerPath[0] = -1;
		for (int idx = 1; idx < eulerPath.size(); idx++) {
			int e = eulerPath.get(idx);
			if (firstOccurenceInEulerPath[e] == 0) {
				firstOccurenceInEulerPath[e] = idx;
			}
		}

		return eulerPath;
	}

	private void eulerPath(TreeNode root) {
		if (root == null)
			return;
		eulerPath.add(root.getData());
		eulerPathOfDepth.add(root.getDepth());
		if (root.getChildern() != null) {
			for (TreeNode child : root.getChildern()) {
				eulerPath(child);
				size++;
				eulerPath.add(root.getData());
				eulerPathOfDepth.add(root.getDepth());
			}

		}
		return; // to make it visualize clearly
	}

	public int getSize() {
		return size + 1;
	}

	public void setSize(int size) {
		this.size = size;
	}

}

/**************************************
 * Tree Node
 ***************************************/
class TreeNode {

	private TreeNode parent;
	private List<TreeNode> childern;
	private int data;
	private int depth;

	public TreeNode(int data) {
		this.data = data;
		this.parent = null;
		this.childern = null;
		this.depth = 0;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public List<TreeNode> getChildern() {
		return childern;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setChildern(TreeNode... childern) {
		this.childern = new ArrayList<>();
		for (TreeNode child : childern) {
			child.setParent(this);
			this.childern.add(child);
		}

	}

}

class TreeMaker {

	public static TreeNode makeTree() {

		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);

		TreeNode node10 = new TreeNode(10);
		node10.setChildern(node12, node13);

		TreeNode node11 = new TreeNode(11);
		TreeNode node7 = new TreeNode(7);
		node7.setChildern(node10, node11);

		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		TreeNode node6 = new TreeNode(6);

		node6.setChildern(node8, node9);

		TreeNode node5 = new TreeNode(5);

		TreeNode node3 = new TreeNode(3);

		node3.setChildern(node5, node6, node7);

		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);

		TreeNode node1 = new TreeNode(1);

		node1.setChildern(node2, node3, node4);

		updateDepth(node1);
		return node1;

	}

	private static void updateDepth(TreeNode node) {
		if (node == null)
			return;
		if (node.getChildern() != null) {
			for (TreeNode child : node.getChildern()) {
				child.setDepth(node.getDepth() + 1);
				updateDepth(child);
			}
		}
		return;
	}

}

class RMQUsingEulerPath {

	private int[] eulerpath;
	private int[] depthEulerpath;
	private int[] firstOccurenceInEulerPath;

	public RMQUsingEulerPath(int[] eulerpath, int[] depthEulerpath, int[] firstOccurenceInEulerPath) {
		this.eulerpath = eulerpath;
		this.depthEulerpath = depthEulerpath;
		this.firstOccurenceInEulerPath = firstOccurenceInEulerPath;
	}

	public int[] getEulerpath() {
		return eulerpath;
	}

	public void setEulerpath(int[] eulerpath) {
		this.eulerpath = eulerpath;
	}

	public int[] getDepthEulerpath() {
		return depthEulerpath;
	}

	public void setDepthEulerpath(int[] depthEulerpath) {
		this.depthEulerpath = depthEulerpath;
	}

	public int[] getFirstOccurenceInEulerPath() {
		return firstOccurenceInEulerPath;
	}

	public void setFirstOccurenceInEulerPath(int[] firstOccurenceInEulerPath) {
		this.firstOccurenceInEulerPath = firstOccurenceInEulerPath;
	}

}

public class EulerPath {

	public static void main(String[] args) {

		Tree tree = new Tree(TreeMaker.makeTree());
		List<Integer> eulerpath = tree.eulerPath();
		List<Integer> depthEulerPath = tree.getEulerPathOfDepth();

		System.out.println(tree.getSize());

		System.out.println(eulerpath);
		System.out.println(depthEulerPath);
		System.out.println(Arrays.toString(tree.getFirstOccurenceInEulerPath()));

	}

}
