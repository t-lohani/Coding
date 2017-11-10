package array;

public class ShortestWordDistance {

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "practice";
		
		System.out.println(shortestDistance(words, word1, word2));
	}

	public static int shortestDistance(String[] words, String word1, String word2) {
        int ind1 = -1;
        int ind2 = -1;
        
        int answer = Integer.MAX_VALUE;
        
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1))
                ind1 = i;
            else if (words[i].equals(word2))
                ind2 = i;
            
            if (ind1!=-1 && ind2!=-1) {
                answer = Math.min(answer, Math.abs(ind1-ind2));
            }
        }
        
        return answer;
    }
}
