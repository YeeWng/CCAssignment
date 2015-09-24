package ch4;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;

public class Solution41 {

	/**
	 * Graph node class
	 * 
	 * @author Matrix
	 *
	 */
	public static class Node {
		int index;
		boolean visited;
		public Node (int i) {
			index = i;
			visited = false;
		}
	}
	
	/**
	 * Graph class 
	 * Determine whether there is route between two nodes 
	 * 	in a directed graph.
	 * Algorithm: traverse graph 
	 * Time: O(n) n is the node number
	 * Space: O(n)
	 * 
	 * @author Matrix
	 *
	 */
	public static class Graph {
		// Here used TreeMap as Hash table to save graph
		TreeMap<Integer, LinkedList<Node>> g = new TreeMap<Integer, LinkedList<Node>>();
		
		public void addAdjcentLink(int[] adj) {
			LinkedList<Node> adjlink = new LinkedList<Node>();
			for (int i = 0; i < adj.length; i++) {
				Node ni = new Node(adj[i]);
				adjlink.add(ni);
			}
			if (!g.containsKey(adj[0]))
				g.put(adj[0], adjlink);
		}
		
		public boolean bfs_traverse(Node st_node, Node ed_node) {
			Queue<Node> q = new LinkedList<Node>();
	        
	        st_node.visited = true;
	        q.add(st_node);
	        while(!q.isEmpty()) {
	            Node u = q.poll();
	            if (u != null) {
		            for (Node v : g.get(u.index)) {
		            	if (v.index == ed_node.index)
		            		return true;
		                if (!v.visited) {
		                	v.visited = true;
		                	q.add(v);
		                }
		            }
	            }
	        }
	        return false;
		}
		
		public void print() {
			for (Map.Entry<Integer, LinkedList<Node>> i: g.entrySet()) {
				LinkedList<Node> nodes = i.getValue();
				System.out.print(i.getKey() + "\t");
				for (Node j : nodes) {
					System.out.print(j.index + " (" + j.visited + ")\t");
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * Testing cases
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph();
		int[] adj1 = {1, 2, 3};
		int[] adj2 = {2, 3, 4};
		int[] adj3 = {3, 4};
		int[] adj4 = {4, 5};
		int[] adj5 = {5};
		int[] adj6 = {6};
		g.addAdjcentLink(adj1);
		g.addAdjcentLink(adj2);
		g.addAdjcentLink(adj3);
		g.addAdjcentLink(adj4);
		g.addAdjcentLink(adj5);
		g.addAdjcentLink(adj6);
		g.print();
		boolean ret = g.bfs_traverse(new Node(1), new Node(6));
		System.out.println("Node(1) and Node(6) route: " + ret);
		System.out.println("---------------------");
		g.print();
	}

}
