package maths;

public class PerfectNumber {

	public static void main(String[] args) {
		System.out.println(checkPerfectNumber(28));
	}

	public static boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;
        
        return sum == num;
    }
}
