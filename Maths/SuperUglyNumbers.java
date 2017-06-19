/*
 *  Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
(4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer. 
 * */

package maths;

public class SuperUglyNumbers {

	public static void main(String[] args) {
		int n = 56;
		int[] primes = {3,5,7,11};
		System.out.println(nthSuperUglyNumber(n, primes));
	}

	public static int[] powerArr;
    
    public static int nthSuperUglyNumber(int n, int[] primes) {
        
        if(n==1)
            return 1;
            
        powerArr = new int[primes.length];
        
        int[] numArr = new int[n];
        numArr[0] = 1;
            
        for(int i=1; i<n; i++) {
            numArr[i] = returnMin(numArr, primes, i-1);
        }
        
        return numArr[numArr.length-1];
    }
    
    public static int returnMin(int[] arr, int[] primes, int prevIndex) {
        
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        
        for(int i=0; i<powerArr.length; i++) {
            if(arr[powerArr[i]]*primes[i]<min) {
                min = arr[powerArr[i]]*primes[i];
                minIndex = i;
            }
        }
        
        powerArr[minIndex]++;
        
        if(min<=arr[prevIndex]) {
            return returnMin(arr, primes, prevIndex);
        } else {
            return min;
        }
    }
}
