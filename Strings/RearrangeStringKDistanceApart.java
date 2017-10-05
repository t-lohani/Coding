package strings;

public class RearrangeStringKDistanceApart {

	public static void main(String[] args) {
		String str = "aaabc";
		int k = 2;
		System.out.println(rearrangeString(str, k));
	}

	public static String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        
        for(int i=0;i<length;i++) {
            count[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int index = 0;index<length;index++){
            int candidatePos = findValidMax(count, valid, index);
            if( candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = index+k;
            sb.append((char)('a'+candidatePos));
        }
        return sb.toString();
    }
    
   private static int findValidMax(int[] count, int[] valid, int index){
       int max = Integer.MIN_VALUE;
       int candidatePos = -1;
       for(int i=0;i<count.length;i++){
           if(count[i]>0 && count[i]>max && index>=valid[i]){
               max = count[i];
               candidatePos = i;
           }
       }
       return candidatePos;
   }
}
