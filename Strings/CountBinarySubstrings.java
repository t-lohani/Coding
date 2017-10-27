package strings;

public class CountBinarySubstrings {

	public static void main(String[] args) {
		String s = "10100010010010";
		System.out.println(countBinarySubstrings(s));
	}

	public static int countBinarySubstrings(String s) {
        if (s.length() == 0)
            return 0;
        
        char[] arr = s.toCharArray();
        int curr = 1;
        int prev = 0;
        int answer = 0;
        
        for (int i=1; i<arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                curr++;
            } else {
                prev = curr;
                curr = 1;
            }
            
            if (prev >= curr) {
                answer++;
            }
        }
        
        return answer;
    }
}
