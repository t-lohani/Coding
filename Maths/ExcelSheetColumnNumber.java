/*
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * */

package maths;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println(titleToNumber("EE4"));
	}

	public static int titleToNumber(String s) {
        int noOfChars = s.length();
        
        int sum = 0;
        
        for(int i=noOfChars-1, j=0; i>=0; i--, j++) {
            sum = sum + (s.charAt(i)-'A'+1) * (int)Math.pow(26, j);
        }
        
        return sum;
    }
}
