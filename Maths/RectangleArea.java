/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner.

Assume that the total area is never beyond the maximum possible value of int.

 * */

package maths;

public class RectangleArea {

	public static void main(String[] args) {
		System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int area = (C-A)*(D-B) + (G-E)*(H-F);
        if(E>C||F>D||G<A||H<B)
            return area;
        int leftdownx = A>E? A:E;
        int leftdowny = B>F? B:F;
        int rightupx = C<G? C:G;
        int rightupy = D<H? D:H;
        int duparea = (rightupx-leftdownx)*(rightupy-leftdowny);
        return area-duparea;
    }
}
