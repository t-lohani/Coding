/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		int noOfPar = 5;
		generateParenthesis(noOfPar);
		
		for (int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	
	public static List<String> answer = new ArrayList<>();
    
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return answer;
        }
        
        StringBuilder str = new StringBuilder("(");
        
        generatePar(str, 1, 0, n*2);
        
        return answer;
    }
    
    public static void generatePar(StringBuilder str, int open, int close, int max) {
        if (str.length() == max) {
            answer.add(str.toString());
            return;
        }
        
        if (open < max/2) {
            generatePar(str.append("("), open+1, close, max);
            str.deleteCharAt(str.length()-1);
        }
        
        if (close < open) {
            generatePar(str.append(")"), open, close+1, max);
            str.deleteCharAt(str.length()-1);
        }
    }

}
