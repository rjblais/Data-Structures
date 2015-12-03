/**
 * Data Structures
 * Assignment #2: Stacking Shipping Containers
 * Ryan Blais
 * 09/28/15
 * 
 * Stack implementation
 */

package assignment02;

public class Stack {

	// Use an array as the underlying structure
	private int[] containers;
	private int amount = 0;

	public Stack(int height) {
		containers = new int[height];
	}

	// Implement Stack operations
	public int push(int x) {
		containers[amount] = x;
		amount++;
		return x;					
	}

	public int pop() {
		amount--;
		return containers[amount];
	}

	public int peek() {
		return containers[amount - 1];
	}

	public boolean isFull() {
		return amount == containers.length;
	}

	public boolean isEmpty() {
		return amount == 0;
	}

	public String toString() {
		String s = "";

		for (int i = amount - 1; i >= 0; i--) {
			s += containers[i] + (i == 0 ? "" : ", ");
		}
		return s;
	}

	public boolean find(int x) {

		for (int i = 0; i < amount; i++) {
			if (x == containers[i]) {
				return true;
			}
		}

		return false;
	}
}
