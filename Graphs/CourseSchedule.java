package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{0,1}};
		System.out.println(canFinish(numCourses, prerequisites));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjMat = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        
        for (int i=0; i<prerequisites.length; i++) {
            if (adjMat[prerequisites[i][0]][prerequisites[i][1]] == 0) {
                degree[prerequisites[i][1]]++;
            }
            adjMat[prerequisites[i][0]][prerequisites[i][1]] = 1;
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
            
            for (int i=0; i<adjMat.length; i++) {
                if (adjMat[popped][i] != 0) {
                    degree[i]--;
                    if (degree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        
        return nodes == numCourses;
    }
}
