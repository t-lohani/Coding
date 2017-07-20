/*
 *  Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.

Notes:

    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 * */

package stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(10);
		obj.push(8);
		obj.pop();
		System.out.println(obj.peek());
		System.out.println(obj.empty());
	}

}

class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<Integer>();
        if(stack1.empty()) stack1.push(x);
        else{
            // when poping out elements to the temporary stack, the order of the element would be reversed which make up the requirement of queue
            while(!stack1.empty()){
                tempStack.push(stack1.pop());
            }
            stack1.push(x);
            while(!tempStack.empty()){
                stack1.push(tempStack.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack1.pop();
    }

    // Get the front element.
    public int peek() {
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty();
    }
}
