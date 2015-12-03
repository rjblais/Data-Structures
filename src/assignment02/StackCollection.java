/**
 * Data Structures
 * Assignment #2: Stacking Shipping Containers
 * Ryan Blais
 * 09/28/15
 * 
 * Stack collection data structure
 */

package assignment02;

public class StackCollection {
	// Use array to store Stack objects
	private Stack[] stacks;
	
	public StackCollection(int numStack) {
		stacks = new Stack[numStack];
	}
	
	public Stack getStack(int id) {
		return stacks[id];
	}
	
	public void setStack(int id, Stack stack) {
		stacks[id] = stack;
	}
	
}
