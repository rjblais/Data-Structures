package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class LZW {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter 1 to compress or 2 to decompress: ");
		int choice = in.nextInt(); in.nextLine();
		
		System.out.print("Enter data: ");
		String data = in.nextLine();
		
		ArrayList<String> encodeTable = new ArrayList<String>();
		encodeTable.add("a");
		encodeTable.add("b");
		encodeTable.add("c");
		encodeTable.add("d");
		encodeTable.add("e");
		encodeTable.add("f");
		
		if (choice == 1) {
			System.out.println(compress(data, (ArrayList<String>) encodeTable.clone()));
		} else {
			System.out.println(decompress(data, encodeTable));
		}
		in.close();
	}

	static String compress(String input, ArrayList<String> encodeTable) {
		String newString = input.charAt(0) + "";
		StringBuilder codeList = new StringBuilder();

		char nextChar;
		
		for (int i = 1; i < input.length(); i++) {
			nextChar = input.charAt(i);
			String s = newString + nextChar;
			
			if (encodeTable.contains(s)) {
				newString = s;
				
			} else {
				int index = encodeTable.indexOf(newString);
				codeList.append(index);
				encodeTable.add(s);
				newString = nextChar + "";
			}
		}
		int index = encodeTable.indexOf(newString);
		codeList.append(index);
		//System.out.println(encodeTable);
		return codeList.toString();
	}
	
	static String decompress(String list, ArrayList<String> encodeTable) {
		StringBuilder uncompressed = new StringBuilder();
		
		String oldCode = list.charAt(0) + "";
		uncompressed.append(encodeTable.get(Integer.valueOf(oldCode)));
		//String firstChar = encodeTable.get(Integer.valueOf(oldCode));
		String tempStr;
		
		for (int i = 1; i < list.length(); i++) {
			String newCode = list.charAt(i) + "";
			
			if (encodeTable.size() > Integer.valueOf(newCode)) {
				tempStr = encodeTable.get(Integer.valueOf(newCode));
				encodeTable.add(encodeTable.get(Integer.valueOf(oldCode)) + tempStr.charAt(0));
				//System.out.println(encodeTable.get(encodeTable.size()-1));
			} else {
				tempStr = encodeTable.get(Integer.valueOf(oldCode));
				tempStr = tempStr + tempStr.charAt(0);
				encodeTable.add(tempStr);
			}
			
			uncompressed.append(tempStr);
			//firstChar = tempStr.charAt(0) + "";
			oldCode = newCode;
		}
		return uncompressed.toString();
	}
}	
	