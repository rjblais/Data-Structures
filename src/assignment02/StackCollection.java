package assignment02;

public class StackCollection {
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
