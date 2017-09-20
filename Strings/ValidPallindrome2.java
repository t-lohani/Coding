package strings;

public class ValidPallindrome2 {

	public static void main(String[] args) {
		System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
	}

	public static boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int head = 0;
        int tail = arr.length-1;
        
        while (head <= tail) {
            if (arr[head] != arr[tail]) {
                return checkOnceMore(arr, head+1, tail) || checkOnceMore(arr, head, tail-1);
            }
            head++;
            tail--;
        }
        return true;
    }
    
    public static boolean checkOnceMore(char[] arr, int head, int tail) {
        while (head <= tail) {
            if (arr[head] != arr[tail]) {
                return false;
            }
            head++;
            tail--;
        }
        
        return true;
    }
}
