package ch10;


public class Solution108 {

	/**
	 * Bit Vector as hash table
	 * Bit Manipulation
	 * 
	 */
	void findDuplicates(int[] arr) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < arr.length; i++) {
			int n = arr[i] - 1;
			if (bs.get(n))
				System.out.println(n + 1);
			else
				bs.set(n);
		}
		
	}
	
	public class BitSet {
		int[] bitset;
		public BitSet(int size) {
			// right shift 5 means divide by 32
			bitset = new int[(size >> 5) + 1];
		}
		
		boolean get(int pos) {
			int wordNum = (pos >> 5);
			// 0x1f equals to 31 equals to 0001 1111
			int bitNum = (pos & 0x1F);
			return (bitset[wordNum] & (1 << bitNum)) != 0;
		}
		
		void set(int pos) {
			int wordNum = (pos >> 5);
			int bitNum = (pos & 0x1F);
			bitset[wordNum] |= 1 << bitNum;
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Test case for 1002 and 999 is the duplication number
		 */
		final int N = 32000;
		int[] cas = new int[N];
		for (int i = 0; i < cas.length; i++)
			cas[i] = i + 1;
		cas[1000] = 1002;
		cas[999] = 999;
		Solution108 s = new Solution108();
		s.findDuplicates(cas);
	}

}
