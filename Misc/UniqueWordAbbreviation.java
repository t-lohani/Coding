/*
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> 
false

isUnique("cart") -> 
true

isUnique("cane") -> 
false

isUnique("make") -> 
true
 * */

package array;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordAbbreviation {

	Map<String, Integer> hashMapAbbr = new HashMap<>();
    Map<String, String> hashMapVal = new HashMap<>();
    public UniqueWordAbbreviation(String[] dictionary) {
    	String word;
        String key;
        for (int i=0; i<dictionary.length; i++) {
            word = dictionary[i];
            if (word.length() > 2)
                key = word.charAt(0)+ Integer.toString(word.length()-2) + word.charAt(word.length()-1);
            else
                key = word;
            
            hashMapAbbr.put(key, hashMapAbbr.getOrDefault(key, 0) + 1);
            hashMapVal.put(key, word);
        }
    }

    public boolean isUnique(String word) {
String key;
        
        if (word.length() < 3 || hashMapAbbr.size() == 0) {
            return true;
        } else {
            key = word.charAt(0)+ Integer.toString(word.length()-2) + word.charAt(word.length()-1);
        }
        
        if (hashMapAbbr.getOrDefault(key, 0) == 1) {
            if (word.equals(hashMapVal.get(key)))
                return true;
            else
                return false;
        }
        else if (hashMapAbbr.getOrDefault(key, 0) == 0)
        	return true;
        else
            return false;
    }
    
    public static void main(String[] args) {
    	String[] dictionary  = {"dog"};
    	UniqueWordAbbreviation uwa = new UniqueWordAbbreviation(dictionary);
    	System.out.println(uwa.isUnique("dig"));
    	System.out.println(uwa.isUnique("dug"));
    	System.out.println(uwa.isUnique("dag"));
    	System.out.println(uwa.isUnique("dog"));
    	System.out.println(uwa.isUnique("doge"));
	}
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
