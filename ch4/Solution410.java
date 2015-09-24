package ch4;

public class Solution410 {

	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true; // The empty tree is a subtree of every tree.
		}
		return subTree(t1, t2);
	}
	
	/* Checks if the binary tree rooted at r1 contains the binary tree 
	 * rooted at r2 as a subtree somewhere within it.
	 */
	public static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null) {
			return false; // big tree empty & subtree still not found.
		} else if (r1.value == r2.value && matchTree(r1,r2)) {
			return true;
		}
		return subTree(r1.left, r2) || subTree(r1.right, r2); 
	}

	/* Checks if the binary tree rooted at r1 contains the 
	 * binary tree rooted at r2 as a subtree starting at r1.
	 */
	public static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true; // nothing left in the subtree
		} else if (r1 == null || r2 == null) { 
			return false; // exactly tree is empty, therefore trees don't match
		} else if (r1.value != r2.value) {  
			return false;  // data doesn't match
		} else {
			return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
		}
	}
	
	public static TreeNode createTreeFromArray(int arr[], int st, int ed) {
		if (ed < st)
			return null;
		int mid = (st + ed) >> 1;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createTreeFromArray(arr, st, mid - 1);
		n.right = createTreeFromArray(arr, mid + 1, ed);
		return n;
	}
	
	public static TreeNode createTreeFromArray(int arr[]) {
		return createTreeFromArray(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {2, 3, 1};
		
		TreeNode t1 = createTreeFromArray(array1);
		TreeNode t2 = createTreeFromArray(array2);

		if (containsTree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = createTreeFromArray(array1);
		TreeNode t4 = createTreeFromArray(array3);

		if (containsTree(t3, t4)) {
			System.out.println("t4 is a subtree of t3");
		} else {
			System.out.println("t4 is not a subtree of t3");
		}
	}

	static class TreeNode{
		int value;
		public TreeNode left, right;
		public TreeNode (int value) {
			this.value = value;
		}
	}
}
