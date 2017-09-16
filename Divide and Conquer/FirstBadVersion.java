package divideandconquer;

public class FirstBadVersion {

	public static int firstBadVersion(int n) {
        int head = 1;
        int tail = n;
        while (head < tail) {
            int mid = head + (tail-head) / 2;
            if (!isBadVersion(mid)) {
                head = mid + 1;
            } else {
                tail = mid;
            }
        }        
        return head;
    }
}
