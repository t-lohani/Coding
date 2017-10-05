package strings;

public class ReverseWordsInAStringII {

	public static void main(String[] args) {
		String str = "the sky is blue";
		char[] s = str.toCharArray();
		reverseWords(s);
		
		for (int i=0; i<s.length; i++) {
			System.out.print(s[i]);
		}
	}

	public static void reverseWords(char[] s) {
        int start = 0;
        int end = 0;
        
        while (end < s.length) {
            if (s[end] == ' ') {
                reverse(start, end-1, s);
                start = end+1;
            }
            end++;
        }
        
        reverse(start, end-1, s);
        reverse(0, end-1, s);
    }
    
    public static void reverse(int start, int end, char[] s) {
        while(start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            
            start++;
            end--;
        }
    }
}
