package backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public static void main(String[] args) {
		readBinaryWatch(2);
	}

	public static List<String> answer = new ArrayList<>();
    
    public static List<String> readBinaryWatch(int num) {
        StringBuilder str = new StringBuilder();
        
        generate(str, 0, num);
        
        return answer;
    }
    
    public static void generate(StringBuilder str, int count, int max) {
        if (str.length() == 10) {
            if (count == max) {
                String hours = convertToHours(str.substring(0, 4));
                String minutes = convertToMinutes(str.substring(4));
                if (Integer.parseInt(hours) <12 && Integer.parseInt(minutes) < 60) {
                    answer.add(hours + ":" + minutes);
                    System.out.println(hours + ":" + minutes);
                }
            }
            return;
        }
        
        generate(str.append("0"), count, max);
        str.deleteCharAt(str.length()-1);
        
        if (count < max) {
            generate(str.append("1"), count+1, max);
            str.deleteCharAt(str.length()-1);
        }
    }
    
    public static String convertToHours(String hours) {
        int ans = 0;
        
        for (int i=hours.length()-1, j=0; i>=0; i--, j++) {
            if (hours.charAt(i) == '1') {
                ans += (1<<j);
            }
        }
        
        return ans+"";
    }
    
    public static String convertToMinutes(String minutes) {
        int ans = 0;
        
        for (int i=minutes.length()-1, j=0; i>=0; i--, j++) {
            if (minutes.charAt(i) == '1') {
                ans += (1<<j);
            }
        }
        
        return ans>9?ans+"":"0"+ans;
    }
}
