package demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

//Input  [3,1,4,0,2,2]
//Expected :[0],[1],[3,2,2],[4]]

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

class TreeNodeLevel {
	public int level;
	public int num;
	public TreeNode node;

	public TreeNodeLevel(int level, int num, TreeNode node) {
		this.level = level;
		this.num = num;
		this.node = node;
	}

	@Override
	public String toString() {

		return String.format("row : %d, col : %d,value: %d", level, num, node.val);
	}
}

public class LeetCode987VerticalTraversalOfTree{
	public List<List<Integer>> verticalTraversal(TreeNode root) {

		TreeMap<Integer, List<TreeNodeLevel>> map = new TreeMap<Integer, List<TreeNodeLevel>>();
		Deque<TreeNodeLevel> levelOrder = new ArrayDeque<TreeNodeLevel>();
		levelOrder.offer(new TreeNodeLevel(0, 0, root));

		while (!levelOrder.isEmpty()) {
			TreeNodeLevel curr = levelOrder.poll();
			TreeNode currNode = curr.node;
			int currlevel = curr.level;
			int num = curr.num;
			map.putIfAbsent(num, new ArrayList<TreeNodeLevel>());
			map.get(num).add(curr);

			if (currNode.left != null) {
				levelOrder.add(new TreeNodeLevel(currlevel+1, num - 1, currNode.left));
			}
			if (currNode.right != null) {
				levelOrder.add(new TreeNodeLevel(currlevel+1, num + 1, currNode.right));
			}

		}

		Comparator<TreeNodeLevel> cmp = (x, y) -> {
			if (x.level < y.level)
				return -1;
			else if (x.level > y.level)
				return 1;
			else if (x.level == y.level) {
				if (x.num == y.num)
					return Integer.compare(x.node.val, y.node.val);
				if (x.num < y.num)
					return -1;
				else
					return 1;
			}
			return 0;

		};

		List<List<Integer>> result = new ArrayList<>();
		for (List<TreeNodeLevel> q : map.values()) {
			Collections.sort(q, cmp);
			List<Integer> temp = new ArrayList<>();
			for (TreeNodeLevel t : q) {
				temp.add(t.node.val);
			}

			result.add(temp);
		}
		return result;
	}

	public static void main(String[] args) {

		// 3,1,4,0,2,2
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(2);

		LeetCode987VerticalTraversalOfTree s = new LeetCode987VerticalTraversalOfTree();
		List<List<Integer>> res = s.verticalTraversal(root);
		for (List<Integer> i : res)
			System.out.println(i);

	}
}