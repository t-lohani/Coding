package maths;

public class BeautifulArrangement2 {

	public static void main(String[] args) {
		int[] answer = constructArray(9, 4);
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        int i;
        int head = 1;
        int tail = n;
        for (i=0; i<k; i++) {
            if (i%2==0)
                nums[i] = head++;
            else
                nums[i] = tail--;
        }
        if (k%2==0) {
            while (tail>=head) {
                nums[i++] = tail--;
            }
        } else {
            while (head<=tail) {
                nums[i++] = head++;
            }
        }
        return nums;
    }
}
