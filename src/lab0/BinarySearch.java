/**
 * Data Structures
 * Binary Search
 * Ryan Blais
 * 8/30/15
 * This program will search through a list of numbers to find a specific
 * number's index. The program uses a Do-while loop to search for
 * the target number by using the first and last number's indexes.
 */

package lab0;

public class BinarySearch {
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 7, 8 };
		bs(array, 2, 7, 3);

	}

	static int bs(int[] array, int first, int last, int target) {

		do {
			int i = (first + last) / 2;
			if (array[i] > target) {
				last = i;
			} else if (array[i] < target) {
				first = i;
			} else {
				System.out.println(i);
				return i;
			}
		} while (first != last);
		System.out.println(-1);
		return -1;
	}
}
