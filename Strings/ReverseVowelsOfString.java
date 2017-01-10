/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * */

package Strings;

public class ReverseVowelsOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "Bloomberg";
		test = reverseVowels(test);
		System.out.println(test);
	}
	
	public static String reverseVowels(String s) {
        
        if(s.length()==0)
            return s;
            
        char charArray[] = s.toCharArray();
        int ptrA = 0;
        int ptrB = charArray.length - 1;
        char temp;
        
        while(ptrA<ptrB) {
            for(int i=ptrA; i<charArray.length; i++) {
                if(isVowel(charArray[i])) {
                    ptrA = i;
                    break;
                }   
            }
            
            for(int i=ptrB; i>=0; i--) {
                if(isVowel(charArray[i])) {
                    ptrB = i;
                    break;
                }   
            }
            
            if(ptrA<ptrB) {
                if(isVowel(charArray[ptrA]) && isVowel(charArray[ptrB])) {
                    temp = charArray[ptrA];
                    charArray[ptrA] = charArray[ptrB];
                    charArray[ptrB] = temp;                    
                }
                ptrA++;
                ptrB--;
            }
        }
        return new String(charArray);
    }
    
    public static boolean isVowel(char ch) {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'
        || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
            return true;
        
        else
            return false;  
    }

}
