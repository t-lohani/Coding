package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {

	public static void main(String[] args) {
		
	}

	public int getImportance(List<Employee> employees, int id) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();
        
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        queue.add(id);
        
        while (!queue.isEmpty()) {
            int popped = queue.remove();
            Employee emp = map.get(popped);
            answer += emp.importance;
            
            for (int i=0; i<emp.subordinates.size(); i++) {
                queue.add(emp.subordinates.get(i));
            }
        }
        
        return answer;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};