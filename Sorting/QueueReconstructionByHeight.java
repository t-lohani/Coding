package sorting;
/*
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] answer = reconstructQueue(people);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print("[" + answer[i][0] + ", " + answer[i][1] + "]");
		}
		System.out.println();
	}
	
	public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people.length == 1) {
            return people;
        }
        
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare (int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                
                return b[0] - a[0];
            }
        });
        
        List<int[]> list = new ArrayList<>();
        
        for (int i=0; i<people.length; i++) {
            list.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        
        return list.toArray(new int[people.length][]);
    }

}
