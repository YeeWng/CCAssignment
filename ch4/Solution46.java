package ch4;

import java.util.LinkedList;
import java.util.Queue;


public class Solution46 {

	static class TreeNode{
		int value;
		public TreeNode left, right, paraent;
		public TreeNode (int value) {
			this.value = value;
		}
	}
	
	/**
	 * Find in-order next node in a tree
	 * Time: O(n) when tree is a linkedlist, n is the number of node
	 * Space: O(1)
	 * @param n
	 * @return
	 */
	public static TreeNode inorderSucc(TreeNode n) {
		if (n == null) return null;
		
		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = q.paraent;
			while (x != null && x.left != q) {
				q = x;
				x = x.paraent;
			}
			return x;
		}
	}
	
	private static TreeNode leftMostChild(TreeNode n) {
		if (n == null) return null;
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	public static TreeNode createMinimalHeightBST(int arr[], int st, int ed, TreeNode p) {
		if (ed < st)
			return null;
		int mid = (st + ed) >> 1;
		TreeNode n = new TreeNode(arr[mid]);
		n.paraent = p;
		n.left = createMinimalHeightBST(arr, st, mid - 1, n);
		n.right = createMinimalHeightBST(arr, mid + 1, ed, n);
		return n;
	}
	
	public static TreeNode createMinimalHeightBST(int arr[]) {
		return createMinimalHeightBST(arr, 0, arr.length - 1, null);
	}
	
	public static void print_BST(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int nullCnt = 0;
		while (!q.isEmpty()) {
			nullCnt = 0;
			int layerNum = q.size();
			
			for (int i = 0; i < layerNum; i++) {
				TreeNode u = q.poll();
				
				if (u != null) {
					System.out.print(u.value + " ");
					q.add(u.left);
					q.add(u.right);
				} else {
					nullCnt++;
					q.add(null);
					q.add(null);
					System.out.print("0 ");
				}
			}
			System.out.println();
			if (nullCnt == layerNum)
				break;
		}
	}
	
	/**
	 * testing cases
	 * @param args
	 */
	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		TreeNode root = createMinimalHeightBST(arr);
		print_BST(root);
		TreeNode r = inorderSucc(root.left.right);
		System.out.println("Inorder Succ: " + root.left.right.value + " -> " + r.value);
	}

}
