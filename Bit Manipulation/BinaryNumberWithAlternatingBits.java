package bitmanipulation;

public class BinaryNumberWithAlternatingBits {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(hasAlternatingBits(n));
	}

	public static boolean hasAlternatingBits(int n) {
        n ^= n/4;
        int k = n-1;
        return (n&k)==0 ;
    }
}
