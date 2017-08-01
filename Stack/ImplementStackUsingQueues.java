/*
 *  Implement the following operations of a stack using queues.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.

Notes:

    You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

 * */

package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		 MyStack obj = new MyStack();
		 obj.push(10);
		 obj.pop();
		 System.out.println(obj.top());
		 System.out.println(obj.empty());
	}

}

class MyStack {
    
    Queue<Integer> queue1 = new LinkedList<Integer>();
    int front;
    
    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
        front = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> queue2 = new LinkedList<Integer>();
        while(queue1.size()>2) {
            queue2.add(queue1.remove());
        }
        
        if(queue1.size()==2) {
            front = queue1.peek();
            queue2.add(queue1.remove());
            queue1.remove();
        } else if(queue1.size()==1) {
            queue1.remove();
        }
        
        queue1 = queue2;
    }

    // Get the top element.
    public int top() {
        return front;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}
