package backtracking;

import java.util.HashSet;
import java.util.Set;

public class FlipGame2 {

	public static void main(String[] args) {
		String s = "++----++++-+-+-++++----++-";
		System.out.println(canWin(s));
	}

	public static boolean canWin(String s) {
        char[] arr = s.toCharArray();
        Set<String> set = new HashSet<>();
        return dpBacktrack(arr, set);
    }
    
    public static boolean dpBacktrack(char[] arr, Set<String> set) {
        String str = new String(arr);
        if (set.contains(str)) {
            return true;
        }
        
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] == '+' && arr[i+1] == '+') {
                arr[i] = '-';
                arr[i+1] = '-';
                boolean canWin = !dpBacktrack(arr, set);
                arr[i] = '+';
                arr[i+1] = '+';
                if (canWin) {
                    set.add(str);
                    return true;
                }
            }
        }
        
        return false;
    }
}
