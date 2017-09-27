package divideandconquer;

public class HIndex2 {

	public static void main(String[] args) {
		int[] citations = {0,1,3,5,6};
		System.out.println(hIndex(citations));
	}

	public static int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length-1;
        int len = citations.length;
        
        while(start <= end) {
            int middle = (start+end)/2;
            
            if (citations[middle] == len-middle) {
                return citations[middle];
            } else if (citations[middle] > len-middle) {
                end = middle-1;
            } else {
                start = middle+1;
            }
        }
        
        return len-end-1;
    }
}
