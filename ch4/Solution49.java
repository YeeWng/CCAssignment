package ch4;

import java.util.ArrayList;
import java.util.LinkedList;

import ch4.Solution411.TreeNode;

public class Solution49 {

	/**
	 * Find a tree all possible sequence
	 * Algorithm: dfs (backtracking)
	 * 
	 * @param node
	 * @return
	 */
	public static ArrayList<LinkedList<Integer>> getAllSeq(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		} 
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.value);
		
		ArrayList<LinkedList<Integer>> leftSeq = getAllSeq(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = getAllSeq(node.right);
		
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}
	
	public static void insert(TreeNode root, int d) {
		
		if (d <= root.value) {
			if (root.left == null)
				root.left = new TreeNode(d);
			else
				insert(root.left, d);
		} else {
			if (root.right == null)
				root.right = new TreeNode(d);
			else
				insert(root.right, d);
		}
	}
	
	public static void weaveLists(LinkedList<Integer> first, 
			LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		/**
		 * One list is empty. Add the remainder to [a cloned] prefix and
		 * 	store result. 
		 * 
		 */
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		/**
		 * Recurse with head of first added to the prefix. Removing the
		 * head will damage first, so we’ll need to put it back where we
		 * found it afterwards. 
		 */
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();	
		second.addFirst(headSecond);
	}
	
	/**
	 * Tree node class
	 * 
	 * @author Matrix
	 *
	 */
	static class TreeNode{
		int value;
		public TreeNode left, right;
		public TreeNode (int value) {
			this.value = value;
		}
	}
	
	/**
	 * Testing case
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {100, 50, 20, 75, 150, 120, 170};
		TreeNode root = new TreeNode(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			insert(root, arr[i]);
		}
		ArrayList<LinkedList<Integer>> allSeq = getAllSeq(root);
		for (LinkedList<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
	}

}
