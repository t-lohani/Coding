/*
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

 * */

package hashtable;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

	public static void main(String[] args) {
		int[][] points = {{0, 0}, {1, 0}, {2, 0}};
		System.out.println(numberOfBoomerangs(points));
	}

	public static int numberOfBoomerangs(int[][] points) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int distance;
        int answer = 0;
        for (int i=0; i<points.length; i++) {
            for (int j=0; j<points.length; j++) {
                    
                distance = (int)(Math.pow(points[i][0]-points[j][0], 2) + Math.pow(points[i][1]-points[j][1], 2));
                map.put(distance, map.getOrDefault(distance, 0)+1);
            }
            
            for(int val : map.values()) {
                answer += val * (val-1);
            }            
            map.clear();
        }

        return answer;
    }
}
