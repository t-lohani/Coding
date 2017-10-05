package strings;

public class RepeatedStringMatch {

	public static void main(String[] args) {
		String A = "abcd";
		String B = "abcdabcd";
		
		System.out.println(repeatedStringMatch(A, B));
	}

	public static int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
		int max = (B.length() / A.length()) + 2;
		int count = 0;
		while (count < max) {
			sb.append(A);
			count++;
			if (sb.length() >= B.length()) {
				if (sb.lastIndexOf(B) >= 0) {
					return count;
				}
			}
		}
		return -1;
        
    }
}
