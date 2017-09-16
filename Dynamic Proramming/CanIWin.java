package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {

	public static void main(String[] args) {
		System.out.println(canIWin(20, 300));
	}

	static Map<Integer, Boolean> map;
	static boolean[] pattern;
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0)
            return true;
        
        if ((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal)
            return false;
        
        map = new HashMap<>();
        pattern = new boolean[maxChoosableInteger+1];
        
        return backtrack(desiredTotal);
    }
    
    public static boolean backtrack(int desiredTotal) {
        if (desiredTotal <= 0)
            return false;
        int key = format();
        if (!map.containsKey(key)) {
            for (int i=1; i<pattern.length; i++) {
                if (!pattern[i]) {
                    pattern[i] = true;
                    if(!backtrack(desiredTotal-i)){
                        map.put(key, true);
                        pattern[i] = false;
                        return true;
                    }
                    pattern[i] = false;
                }
            }
            map.put(key, false);
        }
        
        return map.get(key);
    }
    
    public static int format(){
        int num = 0;
        for(boolean b: pattern){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
