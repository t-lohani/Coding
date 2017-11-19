package design;

import java.util.Stack;

public class MaxStack {
	public static void main(String[] args) {
		MyMaxStack ms = new MyMaxStack();
		ms.push(-1919630);
		ms.push(7447491);
		ms.peekMax();
		ms.push(-2983652);
		ms.top();
		ms.popMax();
	}
}

class MyMaxStack {

    Stack<Integer> valStack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MyMaxStack() {
        valStack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        valStack.push(x);
        if (!maxStack.isEmpty()) {
            if (maxStack.peek() > x) {
                maxStack.push(maxStack.peek());
            } else {
                maxStack.push(x);
            }
        } else {
            maxStack.push(x);
        }
    }
    
    public int pop() {
        maxStack.pop();
        return valStack.pop();
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        Stack<Integer> temp = new Stack<>();
        int result = 0;
        while (true) {
            if (top() != peekMax()) {
                temp.push(valStack.pop());
                maxStack.pop();
            } else {
                result = valStack.pop();
                maxStack.pop();
                
                while (!temp.isEmpty()) {
                    push(temp.pop());
                }
                break;
            }
        }
        
        return result;
    }
}