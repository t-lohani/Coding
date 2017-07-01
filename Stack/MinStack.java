/*
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 * */

package stack;

import java.util.ArrayList;

public class MinStack {

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(10);
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
	
	/** initialize your data structure here. */
    
    class Node {
        int val;
        int min;
        public Node(int x) {
            val = x;
        }
    }
    
    ArrayList<Node> stack;
    
    public MinStack() {
        stack = new ArrayList<Node>();
    }
    
    public void push(int x) {
        Node temp = new Node(x);
        
        if(stack.isEmpty()) {
            temp.min = x;
        } else {
            if(stack.get(stack.size()-1).min > x)
                temp.min = x;
            else
                temp.min = stack.get(stack.size()-1).min;
        }
        stack.add(temp);
    }
    
    public void pop() {
        if(!stack.isEmpty())
            stack.remove(stack.size()-1);
    }
    
    public int top() {
        if(!stack.isEmpty())
            return  stack.get(stack.size()-1).val;
             
        return 0;
    }
    
    public int getMin() {
        if(!stack.isEmpty())
            return  stack.get(stack.size()-1).min;
        else
            return 0;
    }
}