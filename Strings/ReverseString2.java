package strings;

public class ReverseString2 {

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		
		System.out.println(reverse(s, k));
	}
	
	public static String reverseStr(String s, int k) {
        if (s.length() == 0) {
            return s;
        }
        
        return recurse(s, k);
    }
    
    public static String recurse(String str, int k) {
        if (str.length() <= 2*k) {
            return reverse(str, k);
        } else {
            return reverse(str.substring(0, 2*k), k) + recurse(str.substring(2*k), k);
        }
    }
    
    public static String reverse(String str, int k) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end;
        if (str.length() <= k) {
            end = str.length()-1;
        } else {
            end = k-1;
        }
        
        while (start <= end) {
            char temp = arr[start];
            arr[start] =arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(arr);
    }
}
