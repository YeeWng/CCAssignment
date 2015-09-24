package ch4;

import java.util.HashMap;

public class Solution412 {

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
//		int newCount = hashTable.getOrDefault(key, 0) + delta;
//		if (newCount == 0) { // Remove when zero to reduce space usage
//			hashTable.remove(key);
//		} else {
//			hashTable.put(key, newCount);
//		}
		
		if (!hashTable.containsKey(key)) {
			hashTable.put(key, 0);
		}
		hashTable.put(key, hashTable.get(key) + delta);
	}

	public static void main(String [] args) {
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		root.right.left.left = new TreeNode(0);	
		System.out.println(countPathsWithSum(root, 0));
		*/
		
		/*TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, 0));*/
		
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
