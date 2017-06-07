/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * */

package maths;

public class Sqrt {

	public static void main(String[] args) {
		int x = 233873;
		System.out.println(mySqrt(x));
	}

	public static int mySqrt(int x) {
        if(x<=0)
            return x;
            
        int ans = 1;
        
        while(Math.pow(ans,2)<=x) {
            ans++;
        }
        
        return --ans;
    }
}
