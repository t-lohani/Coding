/*
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * */

package maths;

public class ReconstructOriginalDigitsFromEnglish {

	public static void main(String[] args) {
		System.out.println(originalDigits("owozzotneeoerr"));
	}

	public static String originalDigits(String s) {
        int[] hash = new int[26];
        int[] count = new int[10];
        char[] chArr = {'z', 'w', 'u', 'f', 'x', 'v', 'g', 'i', 'n', 'r'};
        String[] arr = {"zero", "two", "four", "five", "six", "seven", "eight", "nine", "one", "three"};
        int[] nums = {0, 2, 4, 5, 6, 7, 8, 9, 1, 3};
        char[] charArr = s.toCharArray();
        StringBuilder str = new StringBuilder();
        
        for (int i=0; i<charArr.length; i++) {
            hash[charArr[i]-'a']++;
        }
        
        for (int i=0; i<10; i++) {
            if (hash[chArr[i]-'a'] > 0) {
                int counter = hash[chArr[i]-'a'];
                count[nums[i]] = counter;
                String temp = arr[i];
                for (int j=0; j<temp.length(); j++) {
                    hash[temp.charAt(j)-'a'] -= counter;
                }
            }
        }
        
        for (int i=0; i<10; i++) {
            if (count[i] > 0) {
            	for (int j=0; j<count[i]; j++) {
            		str.append(i + "");
            	}
            }
        }
        
        return str.toString();
    }
}
