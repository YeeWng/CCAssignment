package ch4;

public class Solution44 {

	/**
	 * Check whether a tree is a balance tree
	 * Tree traverse (dfs)
	 * Time: O(n) n is the node number
	 * Space: O(1)
	 * 
	 * @param tree
	 * @return
	 */
	public static boolean checkBalance(TreeNode root) {
		if (root == null) return true;
		return (Math.abs(height(root.left) - height(root.right)) <= 1) && 
				checkBalance(root.left) && checkBalance(root.right);
	}
	
	public static int height(TreeNode root) {
		if (root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases
		 */
		System.out.println("Ground truth is balanced:");
		TreeNode root = null;
		System.out.println(checkBalance(root));
		root = new TreeNode(1);
		System.out.println(checkBalance(root));
		root.left = new TreeNode(2);
		System.out.println(checkBalance(root));
		root.right = new TreeNode(3);
		System.out.println(checkBalance(root));
		root.left.right = new TreeNode(4);
		System.out.println(checkBalance(root));
		root.right.left = new TreeNode(5);
		System.out.println(checkBalance(root));
		
		System.out.println("Should be not balanced:");
		root.left.right.right = new TreeNode(6);
		System.out.println(checkBalance(root));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
}
