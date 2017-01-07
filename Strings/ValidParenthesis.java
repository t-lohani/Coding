/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */

package Strings;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		String test = "(())";
		System.out.println(isValid(test));
	}
	
	public static boolean isValid(String s) {
        if(s.length()==0)
            return true;
            
        if(s.length()%2!=0)
            return false;
            
        Stack<Character> parStack = new Stack<Character>();
        char compare;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                parStack.push(s.charAt(i));
                
            else {
                if(parStack.empty())
                    return false;
                    
                compare = parStack.pop();
                
                if(s.charAt(i)==')' && compare!='(')
                    return false;
                if(s.charAt(i)=='}' && compare!='{')
                    return false;
                if(s.charAt(i)==']' && compare!='[')
                    return false;
            }
        }
        
        if(parStack.empty())
            return true;
        else
            return false;
    }

}
