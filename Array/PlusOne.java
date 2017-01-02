/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 * */

package array;

public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] digits = {5,7,4};
		digits = plusOne(digits);
		
		for (int i=0; i<digits.length; i++) {
			System.out.print(digits[i] + " ");
		}
	}
	
	public static int[] plusOne(int[] digits) {
        
        if(digits.length==0) {
            digits = new int[1];
            digits[0] = 0;
        }
            
        int carry = 1;
        
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i]==9 && carry==1)
                digits[i] = 0;
            else {
                if(carry==1) {
                    digits[i] = digits[i] + 1;
                    carry = 0;
                }
            }
        }
        
        if(carry==1) {
            int[] digitsPlusOne = new int[digits.length+1];
            digitsPlusOne[0] = 1;
            for(int i=0; i<digits.length; i++)
                digitsPlusOne[i+1] = digits[i];
            return digitsPlusOne;
        } else {
            return digits;
        }
    }

}
