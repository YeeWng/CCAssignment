package ch4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution47 {
	
	/**
	 *  Assumption : the nodes are represented by their indices. 
	 *  	indices belong to [0, n-1] integer
	 *  
	 * 	Dependency contains pairs of dependent e.g. pair (a,b) represents
	 * 		node a should be visited after node b
	 *
	 *	Algorithm : Topological sorting.
	 *	Time complexity is O(n) 
	 *		n means the number of edges (pairs of dependency)
	 */
	public static LinkedList<Integer> topoSort(int n, LinkedList<LinkedList<Integer>> dependency) {
		
		LinkedList<Integer> result = new LinkedList<Integer>();
		LinkedList<LinkedList<Integer>> dependent = new LinkedList<LinkedList<Integer>>();
		
		for(int i = 0; i < n; i++)
			dependent.add(new LinkedList<Integer>());
		
		int [] degree = new int [n];
		
		for(int i = 0; i < dependency.size(); i++) {
			int before = dependency.get(i).get(1);
			int after = dependency.get(i).get(0);
			degree[after]++;
			dependent.get(before).add(after);
		}
		
		Queue<Integer> zero_degree = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			if(degree[i] == 0)
				zero_degree.add(i);
		}
		
		while (!zero_degree.isEmpty()) {
			int curr = zero_degree.poll();
			result.add(curr);
			
			LinkedList<Integer> con_cur = dependent.get(curr);
			for(int i = 0; i < con_cur.size(); i++){
				int tmp = con_cur.get(i);
				if (--degree[tmp] <= 0)
					zero_degree.add(tmp);
			}
		}
		
		return result;
	}
	
	/**
	 * Testing cases
	 * 
	 * @param args
	 */
	public static void main(String [] args){
		
		LinkedList<LinkedList<Integer>> depend = new LinkedList<LinkedList<Integer>>();
		depend.add(new LinkedList<Integer>(Arrays.asList(3,0)));
		depend.add(new LinkedList<Integer>(Arrays.asList(1,5)));
		depend.add(new LinkedList<Integer>(Arrays.asList(3,1)));
		depend.add(new LinkedList<Integer>(Arrays.asList(0,5)));
		depend.add(new LinkedList<Integer>(Arrays.asList(2,3)));
		
		LinkedList<Integer> result = topoSort(6, depend);
		if (result.size() == 0)
			System.out.println("no such result!");
		else {
			System.out.println(result);
		}
	}

}
