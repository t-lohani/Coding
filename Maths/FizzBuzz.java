/*
 * Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.

For numbers which are multiples of both three and five output “FizzBuzz”.
 * */

package maths;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		List<String> ans = fizzBuzz(15);
		for (int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
	
	public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        
        if (n<1) {
            return answer;
        }
        
        for (int i=1; i<=n; i++) {
            if (i%3==0 && i%5==0) {
                answer.add("FizzBuzz");
            } else if (i%3==0) {
                answer.add("Fizz");
            } else if (i%5==0) {
                answer.add("Buzz");
            } else {
                answer.add(i+"");
            }
        }
        return answer;
    }

}
