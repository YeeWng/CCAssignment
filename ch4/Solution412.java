package ch4;

import java.util.HashMap;

public class Solution412 {

	/**
	 * Find a path in a tree, which node sum is equal to the given value.
	 * Solution: DP
	 * Time: O(n) n is the node number
	 * Space: O(1)
	 * 
	 * @param root
	 * @param targetSum
	 * @return
	 */
	public static int pathSum(TreeNode root, int targetSum) {
		return pathSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}
	
	public static int pathSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null) return 0;
		
		runningSum += node.value;
		
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.containsKey(sum) ? pathCount.get(sum) : 0;

		incrementHashTable(pathCount, runningSum, 1);
		
		totalPaths += pathSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += pathSum(node.right, targetSum, runningSum, pathCount);
		
		incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
		
		return totalPaths;
	}
	
	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
	
		if (!hashTable.containsKey(key)) {
			hashTable.put(key, 0);
		}
		hashTable.put(key, hashTable.get(key) + delta);
	}

	public static void main(String [] args) {
		/**
		 * Testing cases
		 */
		
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.left.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		System.out.println(pathSum(root, 0));
		System.out.println(pathSum(root, 4));
	}
	
	static class TreeNode{
		int value;
		public TreeNode left, right;
		public TreeNode (int value) {
			this.value = value;
		}
	}

}
