package assignment03;

import java.util.ArrayList;
import java.util.Arrays;

public class HuffmanTree {
	private Node head;
	
	public ArrayList<String> getNumericTraversal() {
		ArrayList<String> list = new ArrayList<String>();
		getNumericTraversal("", head, list);
		return list;
	}
	
	private void getNumericTraversal(String bits, Node head, ArrayList<String> list) {
		if (head.left == null) {
			list.add(head.letter + " " + bits);
		} else {
			getNumericTraversal(bits + "0", head.left, list);
			getNumericTraversal(bits + "1", head.right, list);
		}
	}
	
	public HuffmanTree(Heap source) {
		
		while (source.size > 0) {
			Arrays.sort(source.array, 0, source.size);
			if (source.size == 1) {
				head = source.array[0];
				source.size--;
				
			} else {
				Node newNode = new Node();
				newNode.left = source.array[0];
				newNode.right = source.array[1];
				newNode.num = newNode.left.num + newNode.right.num;
				source.size -= 2;
				
				source.array = shiftLeft(source.array);
				source.array = shiftLeft(source.array);
				
				source.add(newNode);
			}
			
		}
		
	}

	public String decode(String bitString) {
		Node currentNode = head;
		String code = "";
		for (int i = 0; i < bitString.length(); i++) {
			
			currentNode = bitString.charAt(i) == '0' ? currentNode.left : currentNode.right;
			if (currentNode.hasData) {
				code += currentNode.letter;
				currentNode = head;
			}
		}
		return code;
	}
	public String toString(Node head) {
		if (head.left == null || head.right == null) return head.toString();
		return "["+(toString(head.left) + " : " + toString(head.right))+"]";
	}
	public String toString() {
		return toString(head);
	}
	
	public Node[] shiftLeft(Node[] nums) {
		if (nums == null || nums.length <= 1) { return nums; }
		Node start = nums[0];
		System.arraycopy(nums, 1, nums, 0, nums.length - 1);
		nums[nums.length - 1] = start;
		return nums;
	}
	
}
