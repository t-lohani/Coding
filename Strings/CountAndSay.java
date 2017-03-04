/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * */

package strings;

public class CountAndSay {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(countAndSay(n));
	}

	public static String countAndSay(int n) {
        String prev = "1";
        if (n==0 || n==1) {
            return prev;
        }
        StringBuilder str = new StringBuilder();
        
        for (int i=1; i<n; i++) {
            int head = 0;
            int tail = 0;
            char[] arr = prev.toCharArray();
            while (head < arr.length) {
                int count = 0;
                while (tail<arr.length && arr[tail] == arr[head]) {
                    count++;
                    tail++;
                }
                str.append(count).append(arr[head]);
                head = tail;
            }
            prev = str.toString();
            str = new StringBuilder();
        }
        
        return prev;
    }
}
