package ch5;

public class Solution508 {

	/**
	 * Ch5 Question 8: Draw Line
	 * 
	 * Algorithm: brute-force.
	 * 
	 * Time: O(m) m is the bits number in (width * height)
	 * Space: O(m)
	 * 
	 * @param screen
	 * @param width
	 * @param x1
	 * @param x2
	 * @param y
	 */
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;
		if (start_offset != 0) {
			first_full_byte++; // find the full byte 
		}
		
		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if (end_offset != 7) {
			last_full_byte--;  // find the last byte not full 
		}
		
		// Set full bytes
		for (int b = first_full_byte; b <= last_full_byte; b++)
			screen[(width / 8) * y + b] = (byte) 0xFF;
		
		// Make mask for start and end line
		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));
		
		// Set start and end line
		if ((x1 / 8) == (x2 / 8)) { 
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (start_offset != 0) {
				int byte_number = (width / 8) * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;    // count the row and col should be set in start
			}
			if (end_offset != 7) {
				int byte_number = (width / 8) * y + last_full_byte + 1;
				                                     // count the row and col should be set in end 
				screen[byte_number] |= end_mask;
			} 
		}
	}
	
	/**
	 * Print function just to show the result
	 * 
	 */
	public static void printScreen(byte[] screen, int w) {
		int height = screen.length * 8 / w;
		for (int r = 0; r < height; r++) {
			int c = 0;
			while(c < w){
				byte b = screen[(w * r + c)/8];
				// print the corresponding bit
				for (int i = 7; i >= 0; i--)
					System.out.print( (b >> i) & 1 );
				c += 8;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Testing case
		 */
		int w = 8 * 6;
		int h = 20;
		byte[] screen = new byte[w * h / 8];
		
		drawLine(screen, w, 8, 13, 10);
		printScreen(screen, w);
	}

}
