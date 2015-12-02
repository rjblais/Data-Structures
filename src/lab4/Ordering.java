package lab4;

public class Ordering {

	static int cc = 0;
	static long startTime;
	static int sc = 0;
	static int LENGTH = 50000;
	static int[] intArray = new int[LENGTH];
	static int[] temp = new int[LENGTH];

	static boolean nonDescending(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	static void exchangeSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 1; j < a.length - i; j++) {
				cc++;
				if (a[j - 1] > a[j]) {
					sc++;
					int t = a[j - 1];
					a[j - 1] = a[j];
					a[j] = t;
				}
			}
		}
	}

	static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int max = 0;
			for (int j = 1; j < a.length - i; j++) {
				cc++;
				if (a[max] < a[j]) {
					max = j;
				}
			}
			sc++;
			int t = a[max];
			a[max] = a[a.length - i - 1];
			a[a.length - i - 1] = t;
		}
	}

	static void insertionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int temp = a[i + 1]; // new item to insert into the sorted list
			int j = i;
			while (j >= 0 && temp < a[j]) {
				cc++;
				a[j + 1] = a[j];
				j--;
			}
			sc++;
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

	public static void main(String[] args) {
		boolean sorted = false;
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		
		cc = 0;
		sc = 0;
		long startTime = System.nanoTime();
		exchangeSort(intArray);
		System.out.println("The list is sorted: " + nonDescending(intArray));
		System.out.println("The exchange sort required " + cc + " comparisons and " + sc + " swaps.");
		System.out.println("Time to sort: " + ((System.nanoTime() - startTime/1000000000.0) + " seconds"));
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		
		cc = 0;
		sc = 0;
		startTime = System.nanoTime();
		
	}
}
