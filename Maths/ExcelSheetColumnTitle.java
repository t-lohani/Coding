/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 * */

package maths;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		int n = 136;
		System.out.println(convertToTitle(n));
	}

	public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int remainder = (n-1)%26;
            sb.append((char)(65 + remainder));
            n = (n-remainder+1)/26;
        }
        return sb.reverse().toString();
    }
}
