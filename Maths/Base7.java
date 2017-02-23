/*
 * Given an integer, return its base 7 string representation.
 * */

package maths;

public class Base7 {

	public static void main(String[] args) {
		int num = 100;
		
		System.out.println(convertToBase7(num));
	}

	public static String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-1*num);
        }

        if (num < 7) {
            return num+"";
        }
        return convertToBase7(num/7) + "" + num%7;
    }
}
