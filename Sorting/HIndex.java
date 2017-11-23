package sorting;

public class HIndex {

	public static void main(String[] args) {
		int[] citations = {2,4,6,2,3,6,8,4,2,3,5,4,1,2,4,7,8,5};
		System.out.println(hIndex(citations));
	}

	public static int hIndex(int[] citations) {
        int len = citations.length;
        int[] bucket = new int[len+1];
        
        for (int i=0; i<len; i++) {
            if (citations[i] > len) {
                bucket[len]++;
            } else {
                bucket[citations[i]]++;
            }
        }
        
        int sum = 0;
        for (int i=bucket.length-1; i>=0; i--) {
            sum += bucket[i];
            if (sum >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
