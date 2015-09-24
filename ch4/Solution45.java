package ch4;


public class Solution45 {

	/**
	 * Validate one tree is a BST
	 * Tree traverse (dfs)
	 * Time: O(n) n is the node number
	 * Space: O(1)
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isValidBST(TreeNode node, Integer min, Integer max) {
		if (node == null) return true;
		if(node.value <= min || node.value >= max)
			return false;
		
		return isValidBST(node.left, min, node.value) && 
				 !isValidBST(node.right, node.value, max);
	}
	
	/**
	 * Testing cases
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		System.out.println(isValidBST(n1));
	}
	
	static class TreeNode{
		int value;
		public TreeNode left, right;
		public TreeNode (int value) {
			this.value = value;
		}
	}

}
