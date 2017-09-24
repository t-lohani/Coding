package dynamicprogramming;

public class DecodeWays2 {

	public static void main(String[] args) {
		System.out.println(numDecodings("421*023"));
	}

	public static int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = notCombine(s.charAt(0));
        if(s.length() < 2) return (int)res[0];

        res[1] = res[0] * notCombine(s.charAt(1)) + combine(s.charAt(0), s.charAt(1));
        for(int j = 2; j < s.length(); j++) {
            long temp = res[1];
            res[1] = (res[1] * notCombine(s.charAt(j)) + res[0] * combine(s.charAt(j-1), s.charAt(j))) % 1000000007;
            res[0] = temp;
        }
        return  (int)res[1];
    }
    
    private static int notCombine(int ch) {
        if(ch == '*') return 9;
        if(ch == '0') return 0;
        return 1;
    }

    private static int combine(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if(ch1 != '*' && ch2 != '*') {
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        } else if(ch1 == '*' && ch2 == '*') {
            return 9+6;
        } else if(ch1 == '*') {
            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                return 2;
            else
                return 1;
        } else {
            if(Integer.parseInt(""+ch1) == 1 ) {
                return 9;
            } else if(Integer.parseInt(""+ch1) == 2 ) {
                return 6;
            } 
        }
        return 0;
    }
}
