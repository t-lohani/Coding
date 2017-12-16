package maths;

public class MonotoneIncreasingDigits {

	public static void main(String[] args) {
		int N = 354343;
		System.out.println(monotoneIncreasingDigits(N));
	}

	public static int monotoneIncreasingDigits(int N) {
        String inp = N+"";
        
        char[] arr = inp.toCharArray();
        int i=0;
        while (i<arr.length-1) {
            if(arr[i] > arr[i+1]) {
                while (i>0 && arr[i-1] == arr[i]) {
                    i--;
                }
                arr[i] = (char) (arr[i]-1);
                int j = i+1;
                while (j<arr.length) {
                    arr[j] = '9';
                    j++;
                }
                break;
            }
            i++;
        }
        
        String str = new String(arr);
        return Integer.parseInt(str);
    }
}
