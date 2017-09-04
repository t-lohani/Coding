package maths;

import java.util.ArrayList;
import java.util.List;

public class ConvexPolygon {

	public static void main(String[] args) {
		List<List<Integer>> points = new ArrayList<>();
		List<Integer> point1 = new ArrayList<>();
		List<Integer> point2 = new ArrayList<>();
		List<Integer> point3 = new ArrayList<>();
		List<Integer> point4 = new ArrayList<>();
		point1.add(0);
		point1.add(0);
		point2.add(1);
		point2.add(0);
		point3.add(1);
		point3.add(1);
		point4.add(0);
		point4.add(1);
		points.add(point1);
		points.add(point2);
		points.add(point3);
		points.add(point4);
		
		System.out.println(isConvex(points));
	}
	
	public static boolean isConvex(List<List<Integer>> points) {
        
        List<Integer> list1 = points.get(points.size()-1);
        List<Integer> list2 = points.get(0);
        
        points.add(0, list1);
        points.add(list2);

        int prev, curr, next;
        
        boolean pos = false;
        boolean neg = false;
        
        for (int i=1; i<points.size()-1; i++) {
            prev = i-1;
            curr = i;
            next = i+1;
            
            int prod = crossProd(points, prev, curr, next);
            if (prod > 0) {
                pos = true;
            } else if (prod < 0) {
                neg = true;
            }
        }
        return pos^neg;
    }
    
    public static int crossProd(List<List<Integer>> list, int prev, int curr, int next) {
        int Ax = list.get(curr).get(0) - list.get(prev).get(0);
        int Ay = list.get(curr).get(1) - list.get(prev).get(1);
        int Bx = list.get(next).get(0) - list.get(curr).get(0);
        int By = list.get(next).get(1) - list.get(curr).get(1);

        return (Ax*By) - (Bx*Ay);
    }

}
