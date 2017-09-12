package backtracking;

public class BeautifulArrangement {

	public static void main(String[] args) {
		System.out.println(countArrangement(15));
	}
	
	static int answer = 0;
    public static int countArrangement(int N) {
        int[] nums = new int[N];
        
        for (int i=0; i<nums.length; i++) {
            nums[i] = i+1;
        }
        
        backtrack(nums, 0);
        
        return answer;
    }
    
    public static void backtrack(int[] arr, int index) {
        if (index == arr.length) {
            answer++;
            return;
        }
        
        for(int i=index; i<arr.length; i++) {
            swap(arr, index, i);
            if (arr[index]%(index+1)==0 || (index+1)%arr[index]==0)
                backtrack(arr, index+1);
            swap(arr, index, i);
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        if (i+1 < nums.length) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
