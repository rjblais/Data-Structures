/**
 * Data Structures
 * Assignment #3: Building and Decoding Huffman Trees
 * Ryan Blais
 * 10/23/15
 * 
 * Node Implementation
 */

package assignment03;

public class Node implements Comparable<Node>{
	Node left;
	Node right;
	int num;
	char letter;
	boolean hasData;
	
	public String toString() {
		return letter + " " + num;
	}

	@Override
	public int compareTo(Node o) {
		return this.num - o.num;
	}
	
	
}
