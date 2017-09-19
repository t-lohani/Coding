package stack;

import java.util.Stack;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		String s = "cbacdcbc";
		System.out.println(removeDuplicateLetters(s));
	}

	public static String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
    
        for (int i=0; i<arr.length; i++) {
            count[arr[i]-'a']++;
        }
        
        for (int i=0; i<arr.length; i++) {
            int ind = arr[i]-'a';
            count[ind]--;
            
            if (visited[ind]) {
                continue;
            }
            
            while(!stack.isEmpty() && arr[i]<stack.peek() && count[stack.peek()-'a']!=0){ 
                visited[stack.pop()-'a'] = false;
            }
            stack.push(arr[i]);
            visited[ind] = true;
        }
        
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        
        str.reverse();
        return str.toString();
    }
}
