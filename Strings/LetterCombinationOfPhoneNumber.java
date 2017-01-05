package Strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		String test = "123";
		letterCombinations(test);
		
		for (int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	
	public static List<String> answer = new ArrayList<String>();
    public static List<String> letterCombinations(String digits) {
        List<Character> subArr = new ArrayList<Character>();
        char[] charArr = digits.toCharArray();        
        int len = charArr.length;
        if(len==0)
            return answer;
            
        int[] endInd = new int[len];
        int temp;
        for(int i=0; i<len; i++) {
            temp = charArr[i]-'0';
            if(temp==7 || temp==9) {
                endInd[i]=3;
            } else {
                endInd[i]=2;
            }
        }
        
        combine(charArr, endInd, 0, len, subArr);
        
        return answer;
    }
    
    public static void combine(char[] chArr, int[] end, int index, int length, List<Character> list) {
        if(length==list.size()) {
            StringBuilder builder = new StringBuilder(list.size());
            for(Character ch : list) {
                builder.append(ch);
            }
            answer.add(builder.toString());
        } else {
            for(int i=0; i<=end[index]; i++) {
                list.add((char)(getStartVal(chArr[index]-'0')+i));
                combine(chArr, end, index+1, length, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    public static char getStartVal(int num) {
        char ch;
        switch(num) {
            case 2:
                ch = 'a';
                break;
            case 3:
                ch = 'd';
                break;
            case 4:
                ch = 'g';
                break;
            case 5:
                ch = 'j';
                break;
            case 6:
                ch = 'm';
                break;
            case 7:
                ch = 'p';
                break;
            case 8:
                ch = 't';
                break;
            case 9:
                ch = 'w';
                break;
            default:
                ch = 'a';
        }
        
        return ch;
    }

}
