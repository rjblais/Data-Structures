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
	
		// TODO Auto-generated method stub
		return this.num - o.num;
	}
	
	
}
