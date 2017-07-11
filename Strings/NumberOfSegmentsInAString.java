/*
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
 * */

package strings;

public class NumberOfSegmentsInAString {

	public static void main(String[] args) {
		String s = "Hello, my name is John";
		System.out.println(countSegments(s));
	}

	public static int countSegments(String s) {
        String[] parts = s.split(" ");
        int answer = 0;
        
        for (int i=0; i<parts.length; i++) {
            if (parts[i].length() != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
