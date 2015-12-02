package assignment04;

public class HashTable {

	private int size = 0;
	private String[] stringTable = new String[200_000];
	private int[] intTable = new int[200_000];

	public void put(String s, int i) {
		int htIndx = Math.abs(s.hashCode() % stringTable.length);

		if (stringTable[htIndx] != null) {
			int step = 2;

			while (stringTable[htIndx] != null) {
				htIndx = (htIndx + (step * step)) % stringTable.length;
				step++;
			}
		}

		stringTable[htIndx] = s;
		intTable[htIndx] = i;
		size++;
	}

	public int get(String s) {
		int index = s.hashCode() % stringTable.length;

		int step = 2;

		while (stringTable[index] != null && !s.equals(stringTable[index])) {
			index = (index + (step * step)) % stringTable.length;
			step++;
		}

		return (stringTable[index] != null) ? intTable[index] : -1;
	}

	public int size() {
		return size;
	}

	public boolean contains(String s) {
		int index = s.hashCode() % stringTable.length;

		int step = 2;

		while (stringTable[index] != null && !s.equals(stringTable[index])) {
			index = (index + (step * step)) % stringTable.length;
			step++;
		}

		return (stringTable[index] != null);
	}
}
