package array;

import java.util.Arrays;

public class SortTransformedArray {

	public static void main(String[] args) {
		int[] nums = {-4,  -2, 2, 4};
		int a = 1;
		int b = 3;
		int c = 5;
		
		int answer[] = sortTransformedArray(nums, a, b, c);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        
        int[] answer = new int[nums.length];
        if (nums.length == 0)  
            return answer;
            
        if (a==0 && b==0 && c==0) {
            Arrays.fill(answer, 0);
            return answer;
        } else if (a==0 && b==0) {
            Arrays.fill(answer, c);
        } else if (a==0) {
            if (b>0) {
                for (int i=0; i<nums.length; i++) {
                    answer[i] = b*nums[i] + c;
                }
            } else {
                for (int i=nums.length-1, j=0; i>=0; i--, j++) {
                    answer[j] = b*nums[i] + c;
                }
            }
        } else {
            
            int head = 0;
            int tail = nums.length-1;
            double mid = (double) -b/(2*a);
            double left, right;
            int index;
            
            if (a > 0)
            	index = nums.length-1;
            else
            	index = 0;
            
            while (head <= tail) {
                left = Math.abs(mid-nums[head]);
                right = Math.abs(mid-nums[tail]);
                
                if (a > 0) {
                    if (left < right) {
                        answer[index] = (int)Math.pow(nums[tail], 2)*a + nums[tail]*b + c;
                        tail--;
                        index--;
                    } else {
                        answer[index] = (int)Math.pow(nums[head], 2)*a + nums[head]*b + c;
                        head++;
                        index--;
                    }
                } else {
                    if (left < right) {
                        answer[index] = (int)Math.pow(nums[tail], 2)*a + nums[tail]*b + c;
                        tail--;
                        index++;
                    } else {
                        answer[index] = (int)Math.pow(nums[head], 2)*a + nums[head]*b + c;
                        head++;
                        index++;
                    }
                }
            }
        }

        return answer;
    }
}
