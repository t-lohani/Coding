package strings;

public class OneEditDistance {

	public static void main(String[] args) {
		System.out.println(isOneEditDistance("Tarun", "Tarun"));
	}

	public static boolean isOneEditDistance(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        if (Math.abs(sArr.length-tArr.length) > 1)
            return false;
        
        int i=0;
        while (i<sArr.length && i<tArr.length) {
            if (sArr[i] != tArr[i]) {
                return checkOnceMore(sArr, tArr, i+1, i+1) || checkOnceMore(sArr, tArr, i, i+1) || checkOnceMore(sArr, tArr, i+1, i);
            }
            i++;
        }
        
        if (i!=sArr.length || i!=tArr.length) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean checkOnceMore(char[] sArr, char[] tArr, int sInd, int tInd) {
        while(sInd < sArr.length && tInd < tArr.length) {
            if (sArr[sInd] != tArr[tInd]) {
                return false;
            }
            sInd++;
            tInd++;
        }
        
        if (sInd != sArr.length || tInd != tArr.length) {
            return false;
        } else {
            return true;
        }
    }
}
