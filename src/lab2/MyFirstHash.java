/**
 * Data Structures
 * Lab #3: Open Address Lab
 * Ryan Blais
 * 10/21/15
 * 
 */

package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFirstHash {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = new Scanner(new File("dictionary.txt"));
		boolean linear = true;
		int tableSize = 90821;
		int numWords = 45402;
		String[] words = new String[numWords];
		String[] hashTable = new String[tableSize];

		for (int i = 0; i < numWords; i++) {
			words[i] = cin.nextLine();
		}

		int noCollision = 0;
		int collisionCount = 0;
		int probeCount = 0;

		for (int i = 0; i < numWords; i++) {
			int htIndx = Math.abs(words[i].hashCode() % tableSize);

			if (hashTable[htIndx] == null) {
				noCollision++;
			} else {
				collisionCount++;
				int step = 2;

				if (!linear) {
					while (hashTable[htIndx] != null) {
						htIndx = (htIndx + (step * step)) % tableSize;
						probeCount++;
						step++;
					}
				} else {
					while (hashTable[htIndx] != null) {
						htIndx = (htIndx + 1) % tableSize;
						probeCount++;
					}
				}
			}

			hashTable[htIndx] = words[i];
		}
		cin.close();
		System.out.println("This is number of no collisions: " + noCollision);
		System.out.println("This is number of collision: " + collisionCount);
		System.out.println("Total collisions: " + probeCount);

		Scanner input = new Scanner(System.in);
		String searchWord = input.nextLine();
		int index = searchWord.hashCode() % tableSize;

		int step = 2;

		while (hashTable[index] != null
				&& searchWord.compareTo(hashTable[index]) != 0) {
			index = (index + (step * step)) % tableSize;
			step++;
		}
		
		input.close();

	}
}
