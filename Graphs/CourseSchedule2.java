package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
		int[] answer = findOrder(numCourses, prerequisites);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adjMat = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        int[] answer;
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<prerequisites.length; i++) {
            if (adjMat[prerequisites[i][1]][prerequisites[i][0]] == 0) {
                degree[prerequisites[i][0]]++;
            }
            adjMat[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        
        int nodes = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=0; i<degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int popped = queue.remove();
            nodes++;
            list.add(popped);
            for (int i=0; i<adjMat.length; i++) {
                if (adjMat[popped][i] != 0) {
                    degree[i]--;
                    if (degree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        
        if (nodes == numCourses) {
        	answer = new int[list.size()];
            for (int i=0; i<list.size(); i++) {
            	answer[i] = list.get(i);
            }
        } else {
        	answer = new int[0];
        }
        
        
        return answer;
    }
	
}
