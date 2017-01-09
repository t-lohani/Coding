package design;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
	public static void main(String[] args) {
		HitCounter hc = new HitCounter();
		hc.hit(2);
		hc.hit(3);
		hc.hit(4);
		System.out.println(hc.getHits(300));
		System.out.println(hc.getHits(301));
		System.out.println(hc.getHits(302));
		System.out.println(hc.getHits(303));
		System.out.println(hc.getHits(304));
//		hc.hit(501);
		System.out.println(hc.getHits(600));
		
	}
	
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
        
        int lastTime = queue.peek();
        
        while (timestamp-lastTime >= 300 && !queue.isEmpty()) {
            queue.remove();
            if (!queue.isEmpty())
            	lastTime = queue.peek();
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	int lastTime = 0;
    	if (!queue.isEmpty())
        	lastTime = queue.peek();
        
        while (!queue.isEmpty() && timestamp-lastTime >= 300) {
            queue.remove();
            if (!queue.isEmpty())
            	lastTime = queue.peek();
        }
        
        return queue.size();
    }
}
