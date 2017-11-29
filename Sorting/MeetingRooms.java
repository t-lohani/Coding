package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

	public static void main(String[] args) {
		Interval[] intervals = {new Interval(0, 30),
								new Interval(5, 10),
								new Interval(15, 20)};
		System.out.println(canAttendMeetings(intervals));
	}

	public static boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return true;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        
        return true;
    }
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}