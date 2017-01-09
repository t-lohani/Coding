package design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PhoneDirectory {

	public static void main(String[] args) {
		PhoneDirectory pd = new PhoneDirectory(3);
		pd.release(2);
		System.out.println(pd.get());
		pd.release(2);
		pd.release(0);
		System.out.println(pd.get());
		System.out.println(pd.get());
		System.out.println(pd.check(1));
		System.out.println(pd.get());
		pd.release(0);
		System.out.println(pd.get());
		pd.release(0);
		pd.release(0);
		System.out.println(pd.get());
		System.out.println(pd.check(1));
		pd.release(1);
	}
	
	Set<Integer> occupied;
	Queue<Integer> pool;
	int maxNumbers;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        occupied = new HashSet<>();
        pool = new LinkedList<>();
        this.maxNumbers = maxNumbers;
        
        for (int i=0; i<maxNumbers; i++) {
            pool.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
    	if (pool.isEmpty())
    		return -1;
    	
    	int ret = pool.remove();
    	occupied.add(ret);
    	return ret;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !occupied.contains(number) && number < maxNumbers;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
    	if (occupied.contains(number)) {
    		occupied.remove(number);
            pool.add(number);
    	}
    }

}
