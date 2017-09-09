package bitmanipulation;

public class UTF8Validation {

	public static void main(String[] args) {
		int[] data = {197,130,1};
		System.out.println(validUtf8(data));
	}
	
	public static boolean validUtf8(int[] data) {
        if(data==null || data.length==0) return false;
        boolean isValid = true;
        for(int i=0;i<data.length;i++) {
            if(data[i]>255) return false;
            int numberOfBytes = 0;
            if((data[i] & 128) == 0) {
                numberOfBytes = 1;
            } else if((data[i] & 224) == 192) {
                numberOfBytes = 2;
            } else if((data[i] & 240) == 224) {
                numberOfBytes = 3;
            } else if((data[i] & 248) == 240) {
                numberOfBytes = 4;
            } else {
                return false;
            }
            for(int j=1;j<numberOfBytes;j++) {
                if(i+j>=data.length) return false;
                if((data[i+j] & 192) != 128) return false;
            }
            i=i+numberOfBytes-1;
        }
        return isValid;
    }

}
