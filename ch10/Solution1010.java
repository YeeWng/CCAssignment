package ch10;

public class Solution1010 {

	private RankNode root = null;
	
	/**
	 * Question: Rank for stream
	 * 
	 * Each stream number will be inserted to BST
	 * 
	 * @param num
	 */
	void track(int num) {
		if (root == null)
			root = new RankNode(num);
		else
			root.insert(num);
	}
	
	/**
	 * Query a stream number's rank
	 * 
	 * @param num
	 * @return
	 */
	int getRankNum(int num) {
		return root.getRank(num);
	}
	
	/**
	 * BST and maintain rank number (left subtree size + 1)
	 * insert and get is the same as the insert and find in BST
	 * 
	 * Time Complexity: O(log N) N is the BST node number
	 * Space Complexity: O(N)
	 * 
	 * @author Matrix
	 *
	 */
	public class RankNode {
		public int left_num = 0;
		public RankNode left, right;
		public int data = 0;
		public RankNode(int d) {
			data = d;
		}
		
		public void insert(int d) {
			if (d <= data) {
				if (left != null)
					left.insert(d);
				else
					left = new RankNode(d);
				left_num++;
			} else {
				if (right != null)
					right.insert(d);
				else
					right = new RankNode(d);
			}
		}
		
		public int getRank(int d) {
			if (d == data)
				return left_num;
			else if (d < data) {
				if (left == null) return -1;
				else return left.getRank(d);
			} else {
				int right_rank = right==null ? -1 : right.getRank(d);
				if (right_rank == -1)
					return -1;
				else
					return left_num + 1 + right_rank;
			}
		}
		
	}
	
	public static void main(String[] args) {
		/**
		 * Test case
		 */
		Solution1010 s = new Solution1010();
		int[] cas = {5, 1, 4, 4, 5, 9, 7, 13, 3};
		System.out.println("Stream number:");
		for (int i : cas) {
			s.track(i);
			System.out.println(i + " rank = " + s.getRankNum(i));
		}
	}

}
