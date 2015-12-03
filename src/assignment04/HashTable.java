/**
 * Data Structures
 * Assignment #4: LZW Compression using a Hash Table
 * Ryan Blais
 * 12/03/15
 * 
 * Hash table implementation
 */

package assignment04;

public class HashTable {

	private int size = 0; // Keeps track of number of elements
	// Initialize to twice the maximum capacity
	private String[] stringTable = new String[200_000];
	private int[] intTable = new int[200_000];

	// Insert a element into the table
	public void put(String s, int i) {
		int htIndx = Math.abs(s.hashCode()) % stringTable.length;

		if (stringTable[htIndx] != null) {
			int step = 2;
			
			// Quadratic probing to find an empty spot
			while (stringTable[htIndx] != null) {
				htIndx = (htIndx + (step * step)) % stringTable.length;
				step++;
			}
		}

		stringTable[htIndx] = s;
		intTable[htIndx] = i;
		size++;
	}

	// Retrieve an element from the table
	public int get(String s) {
		int index = Math.abs(s.hashCode()) % stringTable.length;

		int step = 2;

		while (stringTable[index] != null && !s.equals(stringTable[index])) {
			index = (index + (step * step)) % stringTable.length;
			step++;
		}

		return (stringTable[index] != null) ? intTable[index] : -1;
	}

	// Get number of elements
	public int size() {
		return size;
	}

	// Check to see if element is in table
	public boolean contains(String s) {
		int index = Math.abs(s.hashCode()) % stringTable.length;

		int step = 2;

		while (stringTable[index] != null && !s.equals(stringTable[index])) {
			index = (index + (step * step)) % stringTable.length;
			step++;
		}

		return (stringTable[index] != null);
	}
}
