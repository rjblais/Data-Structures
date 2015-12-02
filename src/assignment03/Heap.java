package assignment03;

public class Heap {
	Node[] array = new Node[26];
	int size = 0;
	
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
	
	public void add(char letter, int num) {
		Node node = new Node();
		node.letter = letter;
		node.num = num;
		node.hasData = true;
		add(node);
	}

	public String toString() {
		String s = "";
		int pow2 = 1;
		for (int i = 0; i < size; i++) {
			if (i+1 == pow2) {
				//pow2 *= 2;
				//s += "\n";
			}
			Object item = array[i];
			s += item + "\n";
		}
		return s;
	}
}
