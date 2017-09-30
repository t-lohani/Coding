package backtracking;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {

	public static void main(String[] args) {
		String time = "19:34";
		System.out.println(nextClosestTime(time));
	}

	static int diff = Integer.MAX_VALUE;
    static int dayTime = 24*60;
    static String answer = "";
    
    public static String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        
        for (int i=0; i<time.length(); i++) {
            if (i!=2) {
                set.add(time.charAt(i)-'0');
            }
        }
        
        int arr[] = new int[4];
        
        int mins = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3));
        backtrack(set, 0, arr, mins);
        
        if (answer.equals(""))
            return time;
        else
            return answer;
    }
    
    private static void backtrack(Set<Integer> set, int pos, int[] arr, int mins) {
        if (pos == 4) {
            int currHour = arr[0]*10 + arr[1];
            int currMin = arr[2]*10 + arr[3];
            if (currHour > 23) return;
            if (currMin > 59) return;
            
            int currMins = currHour*60 + currMin;
            if (currMins > mins && currMins-mins < diff) {
                diff = currMins - mins;
                answer = (currHour < 10 ? "0"+String.valueOf(currHour) : String.valueOf(currHour))
                        + ":" + (currMin < 10 ? "0" + String.valueOf(currMin) : String.valueOf(currMin));
            } else if (mins > currMins && dayTime - (mins-currMins) < diff) {
                diff = dayTime - (mins-currMins);
                answer = currHour < 10 ? "0"+String.valueOf(currHour) : String.valueOf(currHour)
                        + ":" + (currMin < 10 ? "0" + String.valueOf(currMin) : String.valueOf(currMin));
            }
            return;
        }
        
        for (Integer i : set) {
            arr[pos] = i;
            backtrack(set, pos+1, arr, mins);
        }
    }
}
