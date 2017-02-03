package stack;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		String path = "a/b/c";
		System.out.println(simplifyPath(path));
	}

	public static String simplifyPath(String path) {
        String[] split = path.split("\\/");
        Stack<String> stack = new Stack<>();
        Stack<String> revStack = new Stack<>();
        
        for (int i=0; i<split.length; i++) {
            if (!split[i].equals(".") && !split[i].equals("")) {
                if (split[i].equals("..") && !stack.isEmpty()) {
                    stack.pop();
                } else if (!split[i].equals("..") && !split[i].equals(".")) {
                    stack.push(split[i]);
                }
            }
        }
        
        StringBuilder str = new StringBuilder();
        
        while (!stack.isEmpty()) {
            revStack.push(stack.pop());
        }
        
        while (!revStack.isEmpty()) {
            str.append("/");
            str.append(revStack.pop());
        }

        if (str.length() == 0) {
            return "/";
        }
        return str.toString();
    }
}
