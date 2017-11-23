package maths;

public class LargestPalindromicProduct {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(largestPalindrome(n));
	}

	public static int largestPalindrome(int n) {
        if(n == 1) {
            return 9;
        }
        
        int upperBound = (int) Math.pow(10, n) - 1;
        int lowerBound = upperBound / 10;
        long maxNumber = (long) upperBound * (long) upperBound;
        
        int firstHalf = (int)(maxNumber / (long) Math.pow(10, n));
        
        boolean palindromFound = false;
        long palindrom = 0;
        
        while (!palindromFound) {
            palindrom = createPalindrom(firstHalf);
            
            for (long i = upperBound; upperBound > lowerBound; i--) {
                if (palindrom / i > maxNumber || i * i < palindrom) {
                    break;
                }
                
                if (palindrom % i == 0) {
                    palindromFound = true;
                    break;
                }
            }

            firstHalf--;
        }

        return (int) (palindrom % 1337);
    }
    
    public static long createPalindrom(long num) {
        return Long.parseLong(num + new StringBuilder(num+"").reverse().toString());
    }
}
