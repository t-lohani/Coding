/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 * */

package maths;

public class PallindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(12321));
	}

	public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
            
        return x==reverseInt(x);
    }
    
    public static int reverseInt(int num) {
        
        int reverseNum = 0;
        
        while(num!=0) {
            reverseNum = reverseNum*10 + num%10;
            num = num/10;
        }
        
        return reverseNum;
    }
}
