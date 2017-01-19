/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 * */

package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));
	}

	public static String largestNumber(int[] nums) {
        
		if (nums == null || nums.length == 0) {
			return "";
		}
		
		String[] numStr = new String[nums.length];
		
		for (int i=0; i<numStr.length; i++) {
			numStr[i] = nums[i] + "";
		}
		
		Arrays.sort(numStr, new Comparator<String>() {
			public int compare (String str1, String str2) {
				String s1 = str1 + str2;
    			String s2 = str2 + str1;
    			return s2.compareTo(s1);
			}
		});
		
		if (numStr[0].charAt(0) == '0') {
		    return "0";
		}
		
		StringBuilder strBld = new StringBuilder();
		
		for (int i=0; i<numStr.length; i++) {
			strBld.append(numStr[i]);
		}
		
		return strBld.toString();
    }
	
}
