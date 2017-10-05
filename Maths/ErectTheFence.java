package maths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErectTheFence {

	public static void main(String[] args) {
		Point[] points = {new Point(1,1), new Point(2,2), new Point(2,0), new Point(2,4), new Point(3,3), new Point(4,2)};
		List<Point> answer = outerTrees(points);
		
		for (int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i).x + "," + answer.get(i).y);
		}
	}

	public static List<Point> outerTrees(Point[] points) {
        Set<Point> answer = new HashSet<>();
        
        Point first = points[0];
        int leftMostIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < first.x) {
                first = points[i];
                leftMostIndex = i;
            }
        }
        answer.add(first);
        
        Point cur = first;
        int curIndex = leftMostIndex;
        do {
            Point next = points[0];
            int nextIndex = 0;
            for (int i = 1; i < points.length; i++) {
                if (i == curIndex) continue;
                int cross = crossProductLength(cur, points[i], next);
                if (nextIndex == curIndex || cross > 0 ||
                        (cross == 0 && distance(points[i], cur) > distance(next, cur))) {
                    next = points[i];
                    nextIndex = i;
                }
            }
            
            for (int i = 0; i < points.length; i++) {
                if (i == curIndex) continue;
                int cross = crossProductLength(cur, points[i], next);
                if (cross == 0) {
                	answer.add(points[i]);
                }
            }

            cur = next;
            curIndex = nextIndex;
            
        } while (curIndex != leftMostIndex);
        
        return new ArrayList<Point>(answer);
    }
    
    private static int crossProductLength(Point A, Point B, Point C) {
        int BAx = A.x - B.x;
        int BAy = A.y - B.y;
        int BCx = C.x - B.x;
        int BCy = C.y - B.y;
    
        return (BAx * BCy - BAy * BCx);
    }

    private static int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}