/*
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * */

package Strings;

public class RomanToInteger {

	public static void main(String[] args) {
		String test = "IX";
		System.out.println(romanToInt(test));
	}

	public static int romanToInt(String roman) {
        int result = 0;
        String uRoman = roman.toUpperCase(); //case-insensitive
        for (int i = 0; i < uRoman.length() - 1; i++) {//loop over all but the last character
            if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i + 1))) {
                result -= decodeSingle(uRoman.charAt(i));
            } else {
                result += decodeSingle(uRoman.charAt(i));
            }
        }
        result += decodeSingle(uRoman.charAt(uRoman.length() - 1));
        return result;
    }
    
    private static int decodeSingle(char letter) {
        switch (letter) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}
