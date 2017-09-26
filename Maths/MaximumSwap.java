package maths;

public class MaximumSwap {

	public static void main(String[] args) {
		System.out.println(maximumSwap(98638));
	}

	public static int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] hash = new int[10];
        int len = arr.length;
        
        for (int i=0; i<len; i++) {
            hash[arr[i]-'0'] = i;
        }
        
        for (int i=0; i<len; i++) {
            for (int j=9; j>arr[i]-'0'; j--) {
                if (hash[j] > i) {
                    char temp = arr[hash[j]];
                    arr[hash[j]] = arr[i];
                    arr[i] = temp;
                    String str = new String(arr);
                    return Integer.parseInt(str);
                }
            }
        }
        
        return num;
    }
}
