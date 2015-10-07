package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution107 {
	
	/**
	 * Sort Big File:
	 * 
	 * 1. Method: Mapping integer into Bit Map
	 * 
	 * Time: O(N) N is the number of integer.
	 * Space: Memory size. O(N/8)
	 * 
	 * 2. Follow up: Memory is not enough as Bit Map to hold integer
	 * 
	 *    Method: Mapping integer into Bit Map
	 *    
	 * Time: O(N)
	 * Space: O(N/8)
	 * 
	 * 
	 */
	// test file (small data)
	String filename = "107_data.txt";
	// 107_data.txt content
	// 0 1 1 3 4 2 5 9 6 7 8 9 10 11 12 13 14 15 15 16 17 18 19 20 21 22
	
	
	//below is the real big data file size
	long numInts = ((long) Integer.MAX_VALUE) + 1;
//	long numInts = 24;
	byte[] bitVec = new byte[(int)(numInts / 8)];
	
	// Sort Big File: Basic Solution
	public void findMissingInt() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(filename));
		while (in.hasNextInt()) {
			int n = in.nextInt();
			// bit set
			bitVec[n / 8] |= (byte) (1 << (n % 8));
		}
		
		for (int i = 0; i < bitVec.length; i++) {
			for (int j = 0; j < 8; j++) {
				// bit get
				if ((bitVec[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					// if return we just look for one missing num
					// if not return we will look for all missing num
					return;
				}
			}
		}
	}
	
	// Sort Big File: Follow Up Solution
	public static int findMissingInt(String filename) throws FileNotFoundException {
		// 2 ^ 20 bits = 2 ^ 17 bytes
		int rangeSize = (1 << 20); //  2 ^ 20 bits
		
		int[] blocks = getCountPerBlock(filename, rangeSize); // Get count of number with each block
		int blockIndex = findBloackWithMissing(blocks, rangeSize); // Find a block with a missing value 
		if(blockIndex < 0) return - 1;
		
		// Create bit vector for this range (the same method with basic)
		byte[] bitmap = getBitMapForRange(filename, blockIndex, rangeSize);
		// find 0 in bitmap
		int offset = findZero(bitmap); 
		if (offset < 0) return -1;
		
		return blockIndex * rangeSize + offset;
	}
	
	// Get count of items with each block
    public static int[] getCountPerBlock(String filename, int rangeSize) throws FileNotFoundException{
		int arraySize  = Integer.MAX_VALUE / rangeSize + 1;
		int[] blocks = new int[arraySize];
		Scanner in = new Scanner(new FileReader(filename));
		while(in.hasNext()) {
			int value = in.nextInt();
			blocks[value/rangeSize]++;
		}
		in.close();
		return blocks;
	}
	
    // Find a block with missing value (whose count is low)
	public static int findBloackWithMissing(int[] blocks, int rangeSize){
		for(int i = 0; i < blocks.length; i++) {
			if(blocks[i] < rangeSize)
				return i;
		}
		return -1;
	}
	
	// Create the bit map with different range
	public static byte[] getBitMapForRange(String filename, int blockindex, int rangeSize) throws FileNotFoundException {
		int startRange = blockindex * rangeSize;
		int endSize = startRange +rangeSize;
		byte[] bitmap = new byte[rangeSize/Byte.SIZE];  // mapping into n/8 size 
		 
		Scanner in = new Scanner(new FileReader(filename));
		while( in.hasNext() ) {
			int value = in.nextInt();
			if(startRange <= value && value < endSize) {
				int offset = value - startRange;  // shift bit to show integer
				int mask = ( 1 << (offset % Byte.SIZE) );
				bitmap[offset/ Byte.SIZE] |= mask;
			}
		}
		in.close();
		return bitmap;
	}
	
	// Find zero with bitmap
	public static int findZero(byte[] bitmap) {
    	for (int i = 0; i < bitmap.length; i++) {
    		if (bitmap[i] != ~0) {
    			int bitIndex = findZero(bitmap[i]); // locate the missing value block
    			return Byte.SIZE * i + bitIndex;	// locate the element 
    		}
    	}
        return -1;
    }
	
	// Find bit index that is zero within byte
	public static int findZero(byte b) {
    	for (int i = 0; i < Byte.SIZE; i++)
    		if ( (b & ( 1<< i )) == 0 )
    			return 0;
        return -1;
    }
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution107 s = new Solution107();
		s.findMissingInt();
	}

}
