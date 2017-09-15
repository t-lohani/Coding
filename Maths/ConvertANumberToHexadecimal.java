package maths;

public class ConvertANumberToHexadecimal {

	public static void main(String[] args) {
		System.out.println(toHex(26));
	}

    public static String toHex(int num) {
    	char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num == 0) return "0";
        StringBuilder result = new StringBuilder();
        while(num != 0) {
            result.insert(0, map[(num & 15)]);
            num = (num >>> 4);
        }
        return result.toString();
    }
}
