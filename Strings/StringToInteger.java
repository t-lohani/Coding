/*
 * Implement atoi to convert a string to an integer.
 * */

package Strings;

public class StringToInteger {

	public static void main(String[] args) {
		String test = "-298";
		System.out.println(myAtoi(test));
	}

	public static int myAtoi(String str) {
        if (str == null)
            return 0;
        int i = 0;
        int signSeenCount = 0; // + or - should be seen only once
        boolean isNegetive = false;
        while (i < str.length()) {
            if (signSeenCount == 0 && str.charAt(i) == ' ') {
            } else if (signSeenCount == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                isNegetive = str.charAt(i) == '-' ? true : false;
                signSeenCount++;
            } else if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return 0;
            else
                break;
            i++;
        }
    
        int result = 0; // This is int and not long as is the case with solutions
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            int digit = str.charAt(i) - '0';
            // Overflow check 
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) ) { 
                if (isNegetive)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
    
            result = result * 10 + digit;
            i++;
        }
    
        return isNegetive ? -result : result;
    }
}
