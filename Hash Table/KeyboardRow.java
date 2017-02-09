/*
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard
 * */

package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyboardRow {

	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] answer = findWords(words);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static String[] findWords(String[] words) {
        
        if (words.length == 0) {
            return words;
        }
        
        Set<Character> hash1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> hash2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> hash3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        Set<Character> select;
        
        List<Integer> index = new ArrayList<>();
        
        for (int i=0; i<words.length; i++) {
            if (words[i].length() == 0) {
                continue;
            }
            
            char[] chArr = words[i].toLowerCase().toCharArray();
            
            if (hash1.contains(chArr[0])) {
                select = hash1;
            } else if (hash2.contains(chArr[0])) {
                select = hash2;
            } else {
                select = hash3;
            }
            
            boolean sameSet = true;
            
            for (int j=0; j<chArr.length; j++) {
                if (!select.contains(chArr[j])) {
                    sameSet = false;
                    break;
                }
            }
            
            if (sameSet) {
                index.add(i);
            }
        }
        
        String[] answer = new String[index.size()];
        
        for (int i=0; i<index.size(); i++) {
            answer[i] = words[index.get(i)];
        }
        
        return answer;
    }

}
