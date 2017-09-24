package array;

public class FindTheCelebrity {

	public static void main(String[] args) {

	}

	public int findCelebrity(int n) {
        int celeb = 0;
        
        for (int i=0; i<n; i++) {
            if (knows(celeb, i))
                celeb = i;
        }
        
        for (int i=0; i<celeb; i++) {
            if (knows(celeb, i))
                return -1;
        }
        
        for (int i=0; i<n; i++) {
            if (!knows(i, celeb))
                return -1;
        }
        
        return celeb;
    }
}
