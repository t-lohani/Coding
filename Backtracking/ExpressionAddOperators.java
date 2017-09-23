package backtracking;

import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperators {

	public static void main(String[] args) {
		List<String> answer = addOperators("123456", 75);
		
		for (int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

	private static List<String> res = new LinkedList<String>();
    private static char[] digits;
    private static char[] path;
        
    public static List<String> addOperators(String num, int target) {
        if(num.length() == 0) return res;
        digits = num.toCharArray();
        path= new char[num.length() * 2 - 1];
        long n = 0;
        for(int i = 0 ; i < digits.length ; i ++){
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            backtrack(0, n, i + 1, i + 1, target);
            if(n == 0) break;
        }
        return res;
    }
    
    private static void backtrack(long leftVal, long curVal, int index, int len, int target) {
        if(index == digits.length) {
            if(leftVal + curVal == target)
                res.add(new String(path, 0, len));
            return;
        }
        long n = 0;
        int j = len + 1;
        for(int i = index ; i < digits.length ; i ++){
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];

            path[len] = '+';
            backtrack(leftVal + curVal, n, i + 1, j, target);

            path[len] = '-';
            backtrack(leftVal + curVal, -n, i + 1, j, target);

            path[len] = '*';
            backtrack(leftVal, curVal * n, i + 1, j, target);
            
            if(digits[index] == '0') break;
        }
    }
}
