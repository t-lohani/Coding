package Strings;

public class ZigZagConversion {

	public static void main(String[] args) {
		String test = "I love coding";
		String answer = convert(test, 3);
		System.out.println(answer);
	}
	
	public static String convert(String s, int numRows) {
        if(numRows==1)
            return s;
            
        StringBuilder strBld = new StringBuilder();
        
        for(int i=0; i<numRows; i++) {
            boolean odd = true;
            int variableDiff = 2*numRows - 3;
            for(int j=i; j<s.length(); j=j+variableDiff+1) {
                if(i==0 || i==numRows-1) {
                    strBld.append(s.charAt(j));
                } else {
                    if(odd) {
                        strBld.append(s.charAt(j));
                        variableDiff = 2*numRows - 3 - 2*i;
                        odd = false;
                    } else {
                        strBld.append(s.charAt(j));
                        variableDiff = 2*i - 1;
                        odd = true;
                    }
                }
            }
        }
        
        return strBld.toString();
    }

}
