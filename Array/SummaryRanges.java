package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		int nums[] = {0,2,3,4,6,8,9};
		List<String> ans = summaryRanges(nums);
		
		for (int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

	public static List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        
        if (nums.length == 1) {
            answer.add(String.valueOf(nums[0]));
            return answer;
        }
        
        for (int i=0; i<nums.length; i++) {
            int start = nums[i];
            while (i+1<nums.length && nums[i+1] == nums[i]+1) {
                i++;
            }
            
            if (start != nums[i]) {
                answer.add(start + "->" + nums[i]);
            } else {
                answer.add(String.valueOf(start));
            }
        }
        
        return answer;
    }
}
