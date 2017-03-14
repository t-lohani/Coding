/*
 *  Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. 
 * */

package dynamicprogramming;

public class UglyNumber2 {

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(78));
	}

	public static int twoPower = 0, threePower = 0, fivePower = 0;
    
    public static int nthUglyNumber(int n) {
        
        if(n==1)
            return 1;
            
        int[] numArr = new int[n];
        numArr[0] = 1;
            
        for(int i=1; i<n; i++) {
            numArr[i] = returnMin(numArr, i-1);
        }
        
        return numArr[numArr.length-1];
    }
    
    public static int returnMin(int[] arr, int prevIndex) {
        
        int ret = 0;
        int a = arr[twoPower]*2;
        int b = arr[threePower]*3;
        int c = arr[fivePower]*5;
        
        if(a<b && a<c) {
            twoPower++;
            ret = a;
        } else if(b<c && b<c) {
            threePower++;
            ret = b;
        } else {
            fivePower++;
            ret = c;
        }
        
        if(ret<=arr[prevIndex]) {
            return returnMin(arr, prevIndex);
        } else {
            return ret;
        }
    }
}
