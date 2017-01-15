/*
 * Count the number of prime numbers less than a non-negative number, n.
 * */

package maths;

public class CountPrimes {

	public static void main(String[] args) {
		int n = 56;
		System.out.println(countPrimes(n));
	}
	
	public static int countPrimes(int n) {
        if(n<2)
            return 0;
            
        boolean[] primeMat = new boolean[n];
            
        int check = (int)Math.sqrt(n);
        
        for(int i=2 ; i<=check; i++) {
            if (!primeMat[i]) {
                for(int j=2*i; j<n; j=j+i) {
                    primeMat[j] = true;
                }
            }
        }
        
        int count = 0;
        for(int i=2; i<n; i++) {
            if(!primeMat[i])
                count++;
        }
        
        return count;
    }

}
