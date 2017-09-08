package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {

	public static void main(String[] args) {
		int[][] buildings = {{0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}};
		List<int[]> answer = getSkyline(buildings);
		
		for (int[] item : answer) {
			System.out.println("[" + item[0] + ", " + item[1] + "]");
		}
	}
	
	public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> answer = new ArrayList<>();
        BuildingPoint[] bp = new BuildingPoint[buildings.length*2];
        
        for (int i=0; i<buildings.length; i++) {
            BuildingPoint temp1 = new BuildingPoint(buildings[i][0], buildings[i][2], true);
            bp[2*i] = temp1;
            BuildingPoint temp2 = new BuildingPoint(buildings[i][1], buildings[i][2], false);
            bp[(2*i)+1] = temp2;
        }
        
        Arrays.sort(bp);
        DescendingComparator comp = new DescendingComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        pq.add(0);
        int prev = 0;
        
        for (int i=0; i<bp.length; i++) {
            if (bp[i].isStart) {
                pq.add(bp[i].height);
            } else {
                pq.remove(bp[i].height);
            }
            if (prev != pq.peek()) {
                int[] temp = {bp[i].xDist, pq.peek()};
                answer.add(temp);
                prev = pq.peek();
                int len = answer.size();
                if (len > 1 && answer.get(len-1)[0] == answer.get(len-2)[0]) {
                	answer.remove(len-1);
                	answer.remove(len-2);
                }
            }
        }
        
        return answer;
    }

}

class BuildingPoint implements Comparable<BuildingPoint> {
    int xDist;
    int height;
    boolean isStart;
    
    public BuildingPoint(int x, int h, boolean st) {
        xDist = x;
        height = h;
        isStart = st;
    }
    
    public int compareTo(BuildingPoint point) {
        if (this.xDist != point.xDist) {
            return this.xDist - point.xDist;
        } else {
            return (this.isStart?-this.height:this.height) - (point.isStart?-point.height:point.height);
        }
    }
}

class DescendingComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		return num2 - num1;
	}
}