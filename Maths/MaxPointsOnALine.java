package maths;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		Points[] points = new Points[3];
		points[0] = new Points(0,0);
		points[1] = new Points(1,1);
		points[2] = new Points(1,2);
		
		System.out.println(maxPoints(points));
	}

	public static int maxPoints(Points[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        
        int max = 2;
        Points a, b, c;
        for (int i = 1; i < points.length; i++) {
            a = points[i - 1];
            b = points[i];
            double k = getSlope(a, b);
            
            int count = 2;
            for (int j = 0; j < points.length; j++) {
                if (j == i || j == i - 1) {
                    continue;
                }
                c = points[j];
                if (overlap(a, c) || overlap(b, c) || k == getSlope(b, c)) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
    
	public static boolean overlap(Points a, Points b) {
        return a.x == b.x && a.y == b.y;
    }
    
	public static double getSlope(Points a, Points b) {
        if (a.x == b.x) {
            return Double.POSITIVE_INFINITY;
        } else {
            return ((double) a.y - b.y) / ((double) a.x - b.x);
        }
    }
}

class Points {
	int x;
	int y;
	Points() { x = 0; y = 0; }
	Points(int a, int b) { x = a; y = b; }
}