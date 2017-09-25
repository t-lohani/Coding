package maths;

public class MultiplyStrings {

	public static void main(String[] args) {
		String num1 = "340";
		String num2 = "48293";
		System.out.println(multiply(num1, num2));
	}

	public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int answer[] = new int[len1+len2];
        
        for (int i=len1-1; i>=0; i--) {
            for (int j=len2-1; j>=0; j--) {
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = mul + answer[i+j+1];
                
                answer[i+j+1] = sum%10;
                answer[i+j] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<answer.length; i++) {
            if (!(sb.length() == 0 && answer[i] == 0)) {
                sb.append(answer[i]);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
