/**
 * Data Structures
 * Assignment #4: LZW Compression using a Hash Table
 * Ryan Blais
 * 12/03/15
 * 
 * The purpose of this program is to implement LZW compression with a Hash
 * table and create a commandline compression utility.
 */

package assignment04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
	public static void main(String[] args) throws IOException {
		String text = new String(Files.readAllBytes(Paths.get(args[1]))).trim(); // Extract the file contents
		
		// Zip: -z [file]
		if (args[0].equals("-z")) {
			System.out.println("Zipping: " + args[1]);
			Files.write(Paths.get(args[1] + ".lzw"),
					LZWcompression.compress(text, ' ', '~').getBytes());
			System.out.println("Zipped: " + args[1] + ".lzw ");
		}

		// Unzip: -u [file]
		else if (args[0].equals("-u")) { // Unzip
			System.out.println("Unzipping: " + args[1]);
			Files.write(Paths.get(args[1] + ".unz"),
					LZWcompression.decompress(text, ' ', '~').getBytes());
			System.out.println("Unzipped: " + args[1] + ".unz ");
		}
		System.out.println("Program Terminated");
	}
}
