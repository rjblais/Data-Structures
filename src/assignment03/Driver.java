/**
 * Data Structures
 * Assignment #3: Building and Decoding Huffman Trees
 * Ryan Blais
 * 10/23/15
 * 
 * This program will be designed to encode text characters. The program will 
 * sort the input by the frequency of each character. Huffman encoding of 
 * these characters reduces the space requirements by assigning short
 * encoding to characters occurring more frequently, and longer encodings 
 * to those less frequent. The program will then use a binary tree to 
 * represent the Huffman encoding. The leaves of the tree are the characters
 * being encoded.
 */

package assignment03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[26];
		
		// Input
		while (input.hasNextLine()) {
			String temp = input.nextLine();
			
			if (temp.equalsIgnoreCase("quit")) {
				break;
			}
			
			for (int i = 0; i < temp.length(); i++) {
				array[temp.charAt(i) - 'a'] += 1;
			}
		}
		
		Heap heap = new Heap();
		for (int i = 0; i < 26; i++) {
			if (array[i] > 0) {
				heap.add((char)(i + 'a'), array[i]);
			}	
		}
		System.out.println(heap);
		System.out.println();
	
		System.out.println("Binary tree height: " + (int)(Math.floor(Math.log10(heap.size) / Math.log10(2) + 1)));
		System.out.println("Unique characters in the tree: " + heap.size);
	
		
		HuffmanTree h = new HuffmanTree(heap);
		ArrayList<String> list = h.getNumericTraversal();
		ArrayList<String> encodings =  new ArrayList<String>();
		Collections.sort(list);
	
		for (String item : list) {
			System.out.println(item);
			encodings.add(item.substring(2));
		}
		Collections.sort(encodings);
		
		System.out.println("shortest encoding: " + encodings.get(0));
		System.out.println("longest encoding: " + encodings.get(encodings.size() -1));
		
		System.out.println("Enter strings to be decoded: ");
		
		while (input.hasNextLine()) {
			String temp = input.nextLine();
			
			if (temp.equalsIgnoreCase("quit")) {
				break;
			}
		
		System.out.println(h.decode(temp));
		}
		
		input.close();
	}
}
