package ch1;

public class Solution14 {
	
	private static int countOdd = 0;
	
	/**
	 * Transfer to value from character.
	 * @param c
	 * @return
	 */
	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		} else if (A <= val && val <= Z) {
			return val - A;
		}
		return -1;
	}
	
	/**
	 * The other way to contruct the hash table
	 * @param bitSet
	 * @param idx
	 * @return
	 */
	public static int getBitVector(int bitSet, int idx) {
		if (idx < 0) return bitSet;
		int mask = 1 << idx;	// bit mask
		
		if ((bitSet & mask) == 0) {
			bitSet |= mask;		// set bit
		} else {
			bitSet &= ~mask;	// clear bit
		}
		return bitSet;
	}
	
	/**
	 * Just as the function name. Build Char Frequency Hash
	 * @param phrase
	 * @return
	 */
	public static int[] buildCharFrequencyHash(String phrase) {
		int[] hash = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				hash[x]++;
				
				//
				if (hash[x] % 2 == 1)
					countOdd++;
				else
					countOdd--;
			}
		}
		return hash;
	}
	
	/**
	 * Build Char Frequency BitSet
	 * @param phrase
	 * @return
	 */
	public static int buildCharFrequencyBitSet(String phrase) {
		int bitSet = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitSet = getBitVector(bitSet, x);
		}
		return bitSet;
	}
	
	public static boolean checkOneOdd1(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	public static boolean checkOneOdd2(int bitSet) {
		// check is one bit set
		return (bitSet & (bitSet - 1)) == 0;
	}
	
	/**
	 * I give two ways to determine Permutation Of Palindrome
	 * One is based on array hash structure. The other is based on bit set.
	 * Both algorithm Time Complexity is O(n). And Space Complexity is O(1)
	 * However, I prefer the bit set solution. 
	 * @param phrase
	 * @return
	 */
	public static boolean isPermutationOfPalindrome1(String phrase) {
		int[] table = buildCharFrequencyHash(phrase);
		return checkOneOdd1(table);
	}
	
	public static boolean isPermutationOfPalindrome2(String phrase) {
		int bitset = buildCharFrequencyBitSet(phrase);
		return checkOneOdd2(bitset);
	}
	
	public static void main(String[] args) {
		/**
		 * Testing edge cases.
		 */
		String[] strings = {"Rats live on no evil star",
							"A man, a plan, a canal, panama",
							"Lleve",
							"Tacotac",
							"asda"};
		int cas = 0;
		for (String s : strings) {
			countOdd = 0;
			boolean a = isPermutationOfPalindrome1(s);
			boolean b = isPermutationOfPalindrome2(s);
			System.out.println("Case #" + ++cas + ":" + s);
			if (a == b) {
				System.out.println("Agree: " + a);
			} else {
				System.out.println("Disagree: " + a + ", " + b);
			}
		}
	}

}
