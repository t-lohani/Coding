package slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        char[] chArr = s.toCharArray();
        int answer = 0;
        int head = 0;
        int tail = 0;
        
        while (tail < chArr.length) {
            if (hash[chArr[tail]] == 0) {
                hash[chArr[tail]]++;
            } else if (hash[chArr[tail]] == 1) {
                while (chArr[head] != chArr[tail]) {
                    hash[chArr[head]]--;
                    head++;
                }
                head++;
            }

            tail++;            
            if (tail-head > answer) {
                answer = tail-head;
            }
        }
        
        return answer;
    }
}
