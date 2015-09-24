package ch4;

import java.util.LinkedList;
import java.util.Queue;

public class Solution43 {
	
	/**
	 * Create linked lists for each level nodes of a tree
	 * 
	 * Tree lever traverse (bfs) 
	 * Time: O(n) n is the node number
	 * Space: O(n) linked lists
	 * 
	 * @param root
	 * @return
	 */
	public static LinkedList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		
		LinkedList<LinkedList<TreeNode>> ret = 
				new LinkedList<LinkedList<TreeNode>>();
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
			
			int layerNum = q.size();
			for (int i = 0; i < layerNum; i++) {
				TreeNode u = q.poll();
				
				if (u != null) {
					
					curr.add(u);
					System.out.print(u.value + " ");
					if (u.left != null)
						q.add(u.left);
					if (u.right != null)
						q.add(u.right);
				}
			}
			System.out.println();
			ret.add(curr);
		}
		return ret;
	}
	
	public static TreeNode createMinimalHeightBST(int arr[], int st, int ed) {
		if (ed < st)
			return null;
		int mid = (st + ed) >> 1;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createMinimalHeightBST(arr, st, mid - 1);
		n.right = createMinimalHeightBST(arr, mid + 1, ed);
		return n;
	}
	
	public static TreeNode createMinimalHeightBST(int arr[]) {
		return createMinimalHeightBST(arr, 0, arr.length - 1);
	}
	
	public static void printLevelLinkedList(LinkedList<LinkedList<TreeNode>> ret) {
		for (LinkedList<TreeNode> l : ret) {
			for (TreeNode n : l) {
				System.out.print(n.value + " -> ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		TreeNode root = createMinimalHeightBST(arr);
		LinkedList<LinkedList<TreeNode>> r = createLevelLinkedList(root);
		
		System.out.println("----------------");
		printLevelLinkedList(r);
	}
	
	static class TreeNode{
		int value;
		public TreeNode left, right;
		public TreeNode (int value) {
			this.value = value;
		}
	}

}
