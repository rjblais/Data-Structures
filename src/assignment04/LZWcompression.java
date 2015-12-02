package assignment04;

public class LZWcompression {
	//Wrong: 49 32 50 32 82 121 97 110 115 32 97 32 106 101 119 
	//Right: 17 0  18 0  50 89  65 78  83  0  65 0  74  69  87
	public static String compress(String input, char start, char end) {
		HashTable encodeTable = new HashTable();
		for (char c = start; c <= end; c++) {
			encodeTable.put(c + "", encodeTable.size());
		}

		String newString = input.charAt(0) + "";
		StringBuilder codeList = new StringBuilder();

		char nextChar;

		for (int i = 1; i < input.length(); i++) {
			nextChar = input.charAt(i);
			String s = newString + nextChar;

			if (encodeTable.contains(s)) {
				newString = s;
			} else {
				int index = encodeTable.get(newString);
				codeList.append(index + " ");
				encodeTable.put(s + "", encodeTable.size());
				newString = nextChar + "";
			}
		}
		int index = encodeTable.get(newString);
		codeList.append(index + " ");
		// System.out.println(encodeTable);
		return codeList.toString();
	}

	public static String decompress(String encoded, char start, char end) {
		String[] stringList = encoded.split(" ");
		String[] encodeTable = new String[100_000];
		int tableSize = 0;

		for (char c = start; c <= end; c++) {
			encodeTable[tableSize++] = c + "";
		}

		int[] list = new int[stringList.length];

		for (int i = 0; i < stringList.length; i++) {
			list[i] = Integer.valueOf(stringList[i]);
		}
		StringBuilder uncompressed = new StringBuilder();

		int oldCode = list[0];
		uncompressed.append(encodeTable[oldCode]);
		String tempStr;

		for (int i = 1; i < list.length; i++) {
			int newCode = list[i];

			if (encodeTable.length > Integer.valueOf(newCode)) {
				tempStr = encodeTable[newCode];
				encodeTable[tableSize++] = encodeTable[oldCode]
						+ tempStr.charAt(0);
				// System.out.println(encodeTable.get(encodeTable.size()-1));
			} else {
				tempStr = encodeTable[oldCode];
				tempStr = tempStr + tempStr.charAt(0);
				encodeTable[tableSize++] = tempStr;
			}

			uncompressed.append(tempStr);
			// firstChar = tempStr.charAt(0) + "";
			oldCode = newCode;
		}
		return uncompressed.toString();
	}

}
