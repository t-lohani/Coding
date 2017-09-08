package sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(6,9));
		
		Interval newInterval = new Interval(2,5);
		List<Interval> ans = insert(intervals, newInterval);
		
		for (int i=0; i<ans.size(); i++) {
            System.out.print("[" + ans.get(i).start + "," + ans.get(i).end + "]");
        }
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> answer = new ArrayList<>();
        int k=0;
        
        while (k<intervals.size() && intervals.get(k).start<newInterval.start) {
            k++;
        }
        
        intervals.add(k, newInterval);
        
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
