import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

		while (!stack.isEmpty() || current != null) {
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

	// this is same as bst to greater 
	public TreeNode bstToGst(TreeNode root) {

		int maxTillNow = 0;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode current = root;

		while (!stack.isEmpty() || current != null) {
			while (current != null) {
				stack.push(current);
				current = current.right;
			}

			do {
				current = stack.pop();
				current.val = current.val + maxTillNow;
				maxTillNow = current.val;
				current = current.left;
			} while (current == null && !stack.isEmpty());
		}

		return root;

	}
	
	
	
	
	
	  public List<String> binaryTreePaths(TreeNode root) {
	        List<String> res = new ArrayList<>();
	        pre(root,new String(),res);
	        return res;
	    }
	    
	    public void pre(TreeNode root, String sb,List<String> res){ 
	        if(root== null) return ;
	        sb+=root.val;
	        System.out.println(sb);
	        if(root.left ==null && root.right == null){
	            res.add(sb);
	            return;
	        }
	        if(root.left!=null)
	        	pre(root.left, sb+"->",res);
	        if(root.right!=null)
	        	pre(root.right, sb+"->",res);
	    }
	    
	    public static void main(String[] args) {
			
	    	TreeNode root = new TreeNode(1);
	    	root.left=new TreeNode(2);
	    	root.right=new TreeNode(3);
	    	root.left.right = new TreeNode(5);
	    	
	    	BST2GreaterTree bst = new BST2GreaterTree();
	    	System.out.println(bst.binaryTreePaths(root));
		}
}
