package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

	public static void main(String[] args) {
		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");
		
		int[] answer = exclusiveTime(2, logs);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        int lastTime = 0;
        
        for (int i=0; i<logs.size(); i++) {
            String[] split = logs.get(i).split(":");
            
            if (!stack.isEmpty()) {
                int index = stack.peek();
                answer[index] +=  Integer.parseInt(split[2]) - lastTime; 
            }
            
            lastTime = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                stack.push(Integer.parseInt(split[0]));
            } else {
                int index = stack.pop();
                answer[index]++;
                lastTime++;
            }
        }
        
        return answer;
    }
}
