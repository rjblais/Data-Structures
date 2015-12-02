/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramdriver;

import java.util.ArrayList;

/**
 *
 * @author Rigdon
 */
public class Anagram {
    static ArrayList<String> anagram(String chars){
        ArrayList<String> words = new ArrayList<String>();
        if(chars.length() <= 1){
            words.add(chars);
            return words;
        }
        
        return anagram(chars.substring(1));
    }
}
