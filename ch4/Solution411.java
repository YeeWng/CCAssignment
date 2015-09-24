package ch4;

import java.util.Random;

public class Solution411 {
	
	/**
	 * Random select node from a tree.
	 * Algorithm: generate a sequence and a random number N as index.
	 * 				then, the Nth node in the sequence is the required node.
	 * Time: O(n) n is the number of tree node.
	 * Space: O(1)
	 * 
	 * BSTree basic
	 * Methods:
	 * 	insert();
	 *  find();
	 * 	getNthNode();	Nth means the Nth node in a certain sequence generated 
	 * 					by pre/in/post traverse.
	 * 
	 * @author Matrix
	 *
	 */
	static class Tree {
		
		public TreeNode getRandomNode(TreeNode root) {
			if (root == null) return null;
			
			Random random = new Random();
			int i = random.nextInt(root.size);
			return getNthNode(root, i);
		}
		
		public void insert(TreeNode root, int d) {
			
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
			
			root.size++;
		}
	
		public TreeNode find(TreeNode root, int d) {
			if (d == root.value) {
				return root;
			} else if (d <= root.value) {
				return root.left != null ? find(root.left, d) : null;
			} else if (d > root.value) {
				return root.right != null ? find(root.right, d) : null;
			}
			return null;
		}
	
		public TreeNode getNthNode(TreeNode root, int i) {
			int left_size = (root.left == null ? 0 : root.left.size);
			if (i < left_size) {
				return getNthNode(root.left, i);
			} else if (i == left_size) {
				return root;
			} else {
				return getNthNode(root.right, i - (left_size + 1));
			}
		}
		
		public void print_inoder(TreeNode root) {
			if (root == null) return;
			
			print_inoder(root.left);
			System.out.print(root.value + " ");
			print_inoder(root.right);
		}
	}
	
	/**
	 * Testing cases.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
		Tree tree = new Tree();
		TreeNode root = new TreeNode(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			tree.insert(root, arr[i]);
		}
		
		tree.print_inoder(root);
		System.out.println();
		
		int[] counts = new int[10];
		int sample_times = 100000;
		for (int i = 0; i < sample_times; i++) {
			int d = tree.getRandomNode(root).value;
			counts[d]++;
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i] + " (" + (double)counts[i] / (double)sample_times * 100 +"%)");
		}
	}
	
	/**
	 * Tree node structure
	 * 
	 * @author Matrix
	 *
	 */
	static class TreeNode {
		int value;
		public TreeNode left, right;
		int size;
		public TreeNode (int value) {
			this.value = value;
			this.size = 1;
		}
	}

}
