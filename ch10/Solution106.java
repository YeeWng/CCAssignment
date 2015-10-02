package ch10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution106 {

	/**
	 * Sort Big File:
	 * 		External merge sort.
	 * First: Split the sorce big file into small chunks
	 * Second: Merge small files just like merge sort.
	 *  
	 */
	final int N = 10;
	int line_num = 0;
	ArrayList<String> filenameList = new ArrayList<String>();
	
	public void sortExternalString(String filename) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(filename));
		List<String> list = new ArrayList<String>();
		for (int i = 0; in.hasNextLine(); line_num++) {
			list.add(in.nextLine());
			if (list.size() >= N) {
				Collections.sort(list);
				String chunkName = "out_" + i + ".txt";
				outForChunk(chunkName, list);
				filenameList.add(chunkName);
				i++;
				list.clear();
			}
		}
	}
	
	public void outForChunk(String filename, List<String> list) {
		try {
			File file = new File(filename);
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
	        for (String s : list)
	        	output.write(s + "\r\n");
	        output.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution106 s = new Solution106();
		String filename = "./data.txt";
		s.sortExternalString(filename);
	}

}
