package assignment04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
	public static void main(String[] args) throws IOException {
		String text = new String(Files.readAllBytes(Paths.get(args[1]))).trim();
		if (args[0].equals("-z")) {
			System.out.println("Zipping: " + args[1]);
			Files.write(Paths.get(args[1] + ".lzw"),
					LZWcompression.compress(text, ' ', '~').getBytes());
			System.out.println("Zipped: " + args[1] + ".lzw ");
		}

		else if (args[0].equals("-u")) {
			System.out.println("Unzipping: " + args[1]);
			Files.write(Paths.get(args[1] + ".unz"),
					LZWcompression.decompress(text, ' ', '~').getBytes());
			System.out.println("Unzipped: " + args[1] + ".unz ");
		}
		System.out.println("Program Terminated");
	}
}
