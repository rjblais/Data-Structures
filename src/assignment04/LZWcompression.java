package assignment04;

// LZW Compression Algorithm implementations
public class LZWcompression {
	public static String compress(String input, char start, char end) {
		// Use hash table to store the encodings
		HashTable encodeTable = new HashTable();
		// Insert entire character set into table
		for (char c = start; c <= end; c++) {
			encodeTable.put(c + "", encodeTable.size());
		}

		// Initialize algorithm with first character
		String newString = input.charAt(0) + "";
		StringBuilder codeList = new StringBuilder();

		char nextChar;

		for (int i = 1; i < input.length(); i++) {
			nextChar = input.charAt(i);
			String s = newString + nextChar;

			// Case for existing encoding
			if (encodeTable.contains(s)) {
				newString = s;
			// Case for new encoding
			} else {
				int index = encodeTable.get(newString);
				codeList.append(index + " ");
				encodeTable.put(s + "", encodeTable.size());
				newString = nextChar + "";
			}
		}
		int index = encodeTable.get(newString);
		codeList.append(index + " ");
		return codeList.toString();
	}

	// LZW decompression Algorithm implementations
	public static String decompress(String encoded, char start, char end) {
		// Use array to store encodings
		String[] stringList = encoded.split(" ");
		String[] encodeTable = new String[100_000];
		int tableSize = 0;

		// Insert entire character set into table
		for (char c = start; c <= end; c++) {
			encodeTable[tableSize++] = c + "";
		}

		// Convert encodings into integers
		int[] list = new int[stringList.length];

		for (int i = 0; i < stringList.length; i++) {
			list[i] = Integer.valueOf(stringList[i]);
		}
		StringBuilder uncompressed = new StringBuilder();

		// Initialize with first encoding
		int oldCode = list[0];
		uncompressed.append(encodeTable[oldCode]);
		String tempStr;

		for (int i = 1; i < list.length; i++) {
			int newCode = list[i];

			// Case for existing encoding
			if (tableSize > Integer.valueOf(newCode)) {
				tempStr = encodeTable[newCode];
				encodeTable[tableSize++] = encodeTable[oldCode]
						+ tempStr.charAt(0);
			// Case for new encoding
			} else {
				tempStr = encodeTable[oldCode];
				tempStr = tempStr + tempStr.charAt(0);
				encodeTable[tableSize++] = tempStr;

			}

			uncompressed.append(tempStr);
			oldCode = newCode;
		}
		return uncompressed.toString();
	}

}
