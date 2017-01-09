package design;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	
	public static void main(String[] args) {
		
		MedianFinder mf = new MedianFinder();
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(10);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(5);
		System.out.println(mf.findMedian());
		mf.addNum(0);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
		mf.addNum(1);
		System.out.println(mf.findMedian());
		mf.addNum(0);
		System.out.println(mf.findMedian());
		mf.addNum(0);
		System.out.println(mf.findMedian());
	}
	
    PriorityQueue<Integer> minQ, maxQ;
    
    public MedianFinder() {
    	minQ = new PriorityQueue<>();
    	maxQ = new PriorityQueue<>(new Comparator<Integer>() {
    		public int compare(Integer int1, Integer int2) {
    			if (int1.intValue() > int2.intValue())
    				return -1;
                if (int1.intValue() < int2.intValue())
                	return 1;
    			
                return 0;
    		}
		});
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
    	if (minQ.size() == maxQ.size()) {
    		if (maxQ.size() == 0) {
    			maxQ.add(num);
    			return;
    		}
    		
    		if (num < maxQ.peek())
    			maxQ.add(num);
    		else
    			minQ.add(num);
    	} else if (minQ.size() > maxQ.size()) {
    		if (num < minQ.peek())
    			maxQ.add(num);
    		else {
    			int temp = minQ.remove();
    			minQ.add(num);
    			maxQ.add(temp);
    		}
    	} else {
    		if (num > maxQ.peek()) {
    			minQ.add(num);
    		} else {
    			int temp = maxQ.remove();
    			minQ.add(temp);
    			maxQ.add(num);
    		}
    	}
    }

    // Returns the median of current data stream
    public double findMedian() {
    	if (minQ.size() == 0 && maxQ.size() == 0)
    			return 0.0;
    	
    	if (minQ.size() == maxQ.size()) {
    		return (double) (minQ.peek() + maxQ.peek())/2;
    	}
    	else if (minQ.size() > maxQ.size()) {
    		return (double) minQ.peek();
    	} else {
    		return (double) maxQ.peek();
    	}
    }
};