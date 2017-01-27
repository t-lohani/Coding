/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 * */

package hashtable;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(3544, 67));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder str = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            str.append("-");
        
        str.append(num/den);
        num = num % den;
        if (num == 0) {
            return str.toString();
        }
        
        str.append(".");
        map.put(num, str.length());        
        while (num!=0) {
            num = num*10;
            str.append(num/den);
            num = num%den;
            
            if (map.containsKey(num)) {
                str.insert(map.get(num), "(");
                str.append(")");
                break;
            } else {
                map.put(num, str.length());
            }
        }
        
        return str.toString();
    }
}
