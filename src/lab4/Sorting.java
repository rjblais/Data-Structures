package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sorting {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("tmStrings.txt"));

		long startTime;

		ArrayList<String> arrayList = new ArrayList<String>();

		while (input.hasNextLine()) {
			arrayList.add(input.nextLine());
		}

		input.close();

		for (int i = 10; i <= 100; i += 10) {
			System.out.println(i + " percent");

			String[] a = copyPercentage(arrayList, i);
			startTime = System.currentTimeMillis();
			exchangeSort(a);
			System.out.println("Exchange Sort:");
			System.out.println("Time: "
					+ (System.currentTimeMillis() - startTime));
			System.out.println("List is sorted: " + isSorted(a));
			System.out.println();

			insertionSort(a);
			System.out.println("Insertion Sort:");
			System.out.println("Time: "
					+ (System.currentTimeMillis() - startTime));
			System.out.println("List is sorted: " + isSorted(a));
			System.out.println();

			selectionSort(a);
			System.out.println("Selection Sort:");
			System.out.println("Time: "
					+ (System.currentTimeMillis() - startTime));
			System.out.println("List is sorted: " + isSorted(a));

			// mergeSort(int first, int last)

			System.out.println();
			System.out.println();
		}
	}

	static String[] copyPercentage(ArrayList<String> original, int percent) {
		String[] a = new String[original.size() * percent / 100];

		for (int i = 0; i < a.length; i++) {
			a[i] = original.get(i);
		}
		return a;
	}

	static boolean isSorted(String[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1].compareTo(a[i]) > 0) {
				return false;
			}
		}
		return true;
	}

	static void exchangeSort(String[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 1; j < a.length - i; j++) {

				if (a[j - 1].compareTo(a[j]) > 0) {

					String t = a[j - 1];
					a[j - 1] = a[j];
					a[j] = t;
				}
			}
		}
	}

	static void selectionSort(String[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int max = 0;
			for (int j = 1; j < a.length - i; j++) {
				if (a[max].compareTo(a[j]) > 0) {
					max = j;
				}
			}
			String t = a[max];
			a[max] = a[a.length - i - 1];
			a[a.length - i - 1] = t;
		}
	}

	static void insertionSort(String[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			String temp = a[i + 1]; // new item to insert into the sorted list
			int j = i;
			while (j >= 0 && temp.compareTo(a[j]) < 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
	}

	static void mergeList(int af, int al, int bf, int bl) {
		int currentA = af;
		int currentB = bf;
		int currentC = af;
		int[] temp = new int[LENGTH];

		for (int i = af; i <= bl; i++) {
			temp[i] = intArray[i];
		}
		while (currentA <= al && currentB <= bl) {
			cc++;
			if (temp[currentA] < temp[currentB]) {
				intArray[currentC++] = temp[currentA++];
			} else {
				intArray[currentC++] = temp[currentB++];
			}
		}
		// dump the remaining items from the longer sublist
		if (currentA > al) {
			while (currentB <= bl) {
				intArray[currentC++] = temp[currentB++];
			}
		} else {
			while (currentA <= al) {
				intArray[currentC++] = temp[currentA++];
			}
		}
	}

	static void mergeSort(int first, int last) {
		if (first < last) {
			mergeSort(first, first + (last - first) / 2);
			mergeSort(first + (last - first) / 2 + 1, last);
			mergeList(first, first + (last - first) / 2, first + (last - first)
					/ 2 + 1, last);
		}
	}

}
