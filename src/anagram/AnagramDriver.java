/**
 * Data Structures
 * Recursion Anagram
 * Ryan Blais
 * 9/30/15
 */

package anagram;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramDriver {
	
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a string");
    
        String word;
    
        word = input.next();
        
        byte[] array = word.getBytes();
        Arrays.sort(array);
        word = new String(array);
        
        System.out.println(Anagram.anagram(word));
    
        input.close();
    }
    
}
