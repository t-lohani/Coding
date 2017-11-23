package maths;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

	public static void main(String[] args) {
		int n = 40;
		List<Integer> ans = lexicalOrder(n);
		
		for (int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	public static List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            answer.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return answer;
    }
}
