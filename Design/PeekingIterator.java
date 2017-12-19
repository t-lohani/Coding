package design;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    Integer next;
    Iterator<Integer> itr;
    boolean empty = false;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator;
        if (itr.hasNext()) {
            next = itr.next();
        } else {
            empty = true;
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer ret = next;
        
        if (itr.hasNext()) {
            next = itr.next();
        } else {
            next = null;
            empty = true;
        }
        
        return ret;
	}

	@Override
	public boolean hasNext() {
	    return !empty;
	}
}