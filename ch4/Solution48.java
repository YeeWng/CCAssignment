package ch4;

public class Solution48 {

    /**
     * LCA
     * Recursive approach to find the Lowest Common Ancestor
     * 
     * Time: O(n)
     * Space: O(1)
     * 
     * LCA can be solved by a lot of different algorithms.
     * 	1> Basic recursion
     *  2> LCA -> RMQ can be solved by segmented tree
     *  3> Sparse Table based on Dynamic Programming
     *  4> Tarjan (offline) 
     * 
     * @param root
     * @param a - query Node1
     * @param b - query Node2
     * @return Node that is LCA of a and b
     */
    public static TreeNode findLowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
 
    	TreeNode left = null;
    	TreeNode right = null;
 
        if (root == null) {
            return null;
        }
 
        /**
         * If Node a or Node b is also the root, then the root itself 
         * is LCA
         */
        if (root == a || root == b) {
            return root;
        }
 
        left = findLowestCommonAncestor(root.left, a, b);
        right = findLowestCommonAncestor(root.right, a, b);
 
        /**
         * If Node a and Node b lie in the left, their LCA is in the left.
         * If Node a and Node b lie in the right, their LCA is in the right.
         * Otherwise, root is the LCA
         * 
         */
        if (left != null && right != null) {
            return root;
        }
 
        return (left != null) ? left : right;
    }
	
	public static void main(String args[]) {
		/**
		 * Testing case
		 */
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
 
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(3);
 
        System.out.println("LCA of Node 3 and 9 is: "
                + findLowestCommonAncestor(root, root.right.right.right, root.right.left).value);
         
        System.out.println("LCA of Node 3 and null is: "
                + findLowestCommonAncestor(root, root.right.right.right, null).value);
         
        System.out.println("LCA of Node 11 and null is: "
                + findLowestCommonAncestor(root, root.right.right, null).value);
 
    }
    
	static class TreeNode{
		int value;
		public TreeNode left, right;
		public TreeNode (int value) {
			this.value = value;
		}
	}
}
