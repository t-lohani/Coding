/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * */

package Strings;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "11";
		String str2 = "1";
		
		String answer = addBinary(str1, str2);
		System.out.println(answer);
	}
	
	public static String addBinary(String a, String b) {
        int length = a.length()>b.length()?a.length()+1:b.length()+1;
        
        int[] charArray = new int[length];
        int counter = 0;
        int carry = 0;
        int i, j;
        
        for(i=a.length()-1, j=b.length()-1; i>=0 && j>=0; i--,j--,counter++) {
            if(a.charAt(i)=='0' && b.charAt(j)=='0') {
                if(carry==0)
                    charArray[counter] = 0;
                else {
                    charArray[counter] = 1;
                    carry = 0;
                }
            }
            
            if(a.charAt(i)=='0' && b.charAt(j)=='1') {
                if(carry==0)
                    charArray[counter] = 1;
                else
                    charArray[counter] = 0;
            }
            
            if(a.charAt(i)=='1' && b.charAt(j)=='0') {
                if(carry==0)
                    charArray[counter] = 1;
                else
                    charArray[counter] = 0;
            }
            
            if(a.charAt(i)=='1' && b.charAt(j)=='1') {
                if(carry==0) {
                    charArray[counter] = 0;
                    carry = 1;
                } else
                    charArray[counter] = 1;
            }
        }
        
        if(i==-1 && j==-1)
            charArray[counter] = carry;
        else if(i==-1) {
            for(;j>=0;j--, counter++) {
                if(b.charAt(j)=='0') {
                    if(carry==0)
                        charArray[counter] = 0;
                    else {
                        charArray[counter] = 1;
                        carry = 0;
                    }
                } else {
                    if(carry==0)
                        charArray[counter] = 1;
                    else
                        charArray[counter] = 0;
                }
            }
        } else if(j==-1) {
            for(;i>=0;i--, counter++) {
                if(a.charAt(i)=='0') {
                    if(carry==0)
                        charArray[counter] = 0;
                    else {
                        charArray[counter] = 1;
                        carry = 0;
                    }
                } else {
                    if(carry==0)
                        charArray[counter] = 1;
                    else
                        charArray[counter] = 0;
                }
            }
        }
        
        if(carry==1) {
            charArray[counter] = 1;
            counter++;
        }
        
        String finalStr = "";
        for(counter--; counter>=0; counter--) {
            finalStr = finalStr + charArray[counter];
        }
        
        return finalStr;
    }

}
