package ch4;

public class Solution44 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int height(TreeNode tree) {
		if (tree == null)
			return 0;
		return 1 + Math.max(height(tree.left), height(tree.right));
	}
	
	public static boolean checkBalance(TreeNode tree) {
		if (tree == null)
			return true;
		return Math.abs(height(tree.left) - height(tree.right)) <= 1 && 
				checkBalance(tree.left) && checkBalance(tree.right);
	}
	
	public static void main(String[] args) {
		System.out.println("Should be true:");
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
		
		System.out.println("Should be false:");
		root.left.right.right = new TreeNode(6);
		System.out.println(checkBalance(root));
	}

}
