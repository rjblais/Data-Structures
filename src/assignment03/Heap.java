/**
 * Data Structures
 * Assignment #3: Building and Decoding Huffman Trees
 * Ryan Blais
 * 10/23/15
 * 
 * Heap data structure implementation
 */

package assignment03;

public class Heap {
	// Initialize array of nodes
	Node[] array = new Node[26];
	int size = 0;
	
	// Add node to heap
	public void add(Node node) {
		int index = size;
		int parent = (index - 1) / 2;
		
		array[size] = node;
		while (index > 0) {
			if (array[index].num < array[parent].num) {
				Node temp = array[index];
				array[index] = array[parent];
				array[parent] = temp;
				index = parent;
				parent = (index - 1) / 2;
			} else {
				break;
			}	
		}
		size++;
	}
	
	// Construct Node and add to heap
	public void add(char letter, int num) {
		Node node = new Node();
		node.letter = letter;
		node.num = num;
		node.hasData = true;
		add(node);
	}
	
	// Used to print out itemized view of heap
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			Object item = array[i];
			s += item + "\n";
		}
		return s;
	}
}
