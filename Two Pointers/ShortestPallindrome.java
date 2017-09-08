package twopointers;

public class ShortestPallindrome {

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("abacfghcabakmnchgfcabaiuytrcfghcnmkabachgfcaba"));
	}

	public static String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int head = 0;
        int tail = s.length()-1;
            
        while (tail >= 0) {
            if (arr[head] == arr[tail])
                head++;
            
            tail--;
        }
        
        if (head == arr.length)
            return s;
        
        String suffix = s.substring(head);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, head)) + suffix;
    }
}
