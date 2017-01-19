/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]
 * */

package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2,3));
		intervals.add(new Interval(4,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,9));
		intervals.add(new Interval(1,10));
		
		List<Interval> ans = merge(intervals);
		
		for (int i=0; i<ans.size(); i++) {
            System.out.print("[" + ans.get(i).start + "," + ans.get(i).end + "]");
        }
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() == 0 || intervals.size() == 1) {
            return intervals;
        }
        
        List<Interval> answer = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                
                return a.start - b.start;
            } 
        });
        
        answer.add(intervals.get(0));
        
        for (int i=1, j=0; i<intervals.size(); i++) {
            Interval next = intervals.get(i);
            Interval prev = answer.get(j);
            
            if (prev.end >= next.start) {
                if (prev.end < next.end) {
                    prev.end = next.end;
                    answer.set(j, prev);
                }
            } else {
                answer.add(intervals.get(i));
                j++;
            }
        }
        
        return answer;
     }

}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
