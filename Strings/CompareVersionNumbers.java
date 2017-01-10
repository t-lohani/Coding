package Strings;

public class CompareVersionNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String version1 = "2.3.8";
		String version2 = "2.3.6";
		
		System.out.println(compareVersion(version1, version2));
	}

	public static int compareVersion(String version1, String version2) {
        
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        
        int[] intSplit1 = new int[split1.length];
        int[] intSplit2 = new int[split2.length];
        
        for(int i=0; i<intSplit1.length; i++) {
            intSplit1[i] = Integer.parseInt(split1[i]);
        }
        
        for(int i=0; i<intSplit2.length; i++) {
            intSplit2[i] = Integer.parseInt(split2[i]);
        }
        
        int shorter = intSplit1.length<intSplit2.length?intSplit1.length:intSplit2.length;
        
        for(int i=0; i<shorter; i++) {
            if(intSplit1[i]>intSplit2[i])
                return 1;
            
            if(intSplit1[i]<intSplit2[i])
                return -1;
        }
        
        if(intSplit1.length<intSplit2.length) {
            for(int i=shorter; i<intSplit2.length; i++) {
                if(intSplit2[i]!=0)
                    return -1;
            }
        }
        else if(intSplit1.length>intSplit2.length) {
            for(int i=shorter; i<intSplit1.length; i++) {
                if(intSplit1[i]!=0)
                    return 1;
            }
        }
        else
            return 0;
            
        return 0;
    }
}
