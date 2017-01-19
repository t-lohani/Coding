/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 * */

package bitmanipulation;

public class MaximumProductOfWordLengths {

	public static void main(String[] args) {
		String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		System.out.println(maxProduct(words));
	}

	public static int maxProduct(String[] words) {
        if (words.length == 0 || words.length == 1) {
            return 0;
        }
        
        int[] bitset = new int[words.length];
        int answer = 0;
        int len = words.length;
        
        for (int i=0; i<len; i++) {
            bitset[i] = 0;
            String temp = words[i];
            for (int j=0; j<words[i].length(); j++) {
                bitset[i] |= (1<<temp.charAt(j)-'a');
            }
        }
        
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if ((bitset[i]&bitset[j]) == 0 && (words[i].length()*words[j].length() > answer)) {
                    answer = words[i].length()*words[j].length();
                }
            }
        }
        
        return answer;
     }
}
