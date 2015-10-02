package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution107 {
	
	/**
	 * Bit Vector as hash table
	 * Bit Manipulation
	 * 
	 */
	// test file (small data)
	String filename = "107_data.txt";
	//below is the real big data file size
	//long numInts = ((long) Integer.MAX_VALUE) + 1;
	long numInts = 24;
	byte[] bitVec = new byte[(int)(numInts / 8)];
	
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
					//return;
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution107 s = new Solution107();
		s.findMissingInt();
	}

}
