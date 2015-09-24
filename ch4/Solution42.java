package ch4;

import java.util.LinkedList;
import java.util.Queue;

public class Solution42 {

	static class TreeNode{
		int value;
		public TreeNode left, right;
		public TreeNode (int value) {
			this.value = value;
		}
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
//					if (u.left != null)
						q.add(u.left);
//					if (u.right != null)
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
	
	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		TreeNode root = createMinimalHeightBST(arr);
		print_BST(root);
	}

}
