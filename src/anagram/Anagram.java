package anagram;

import java.util.ArrayList;

public class Anagram {
    static ArrayList<String> anagram(String chars){
        ArrayList<String> words = new ArrayList<String>();

        if (chars.length() <= 1) {
            words.add(chars);
            return words;
        }
        
        for (int i = 0; i < chars.length(); i++) {
        	char q = chars.charAt(i);
        	
        	for (String word: anagram(chars.substring(0, i) + chars.substring(i + 1, chars.length()))) {
        		words.add(q + word);
        	}
        }
        return words;
    }
}
