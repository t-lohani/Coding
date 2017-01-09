package design;

import java.util.HashMap;

public class LFUCache {
    
	public static void main(String[] args) {
//		LFUCache lfu = new LFUCache(2);
//		lfu.put(1, 1);
//		lfu.put(2, 2);
//		System.out.println(lfu.get(1));
//		lfu.put(3, 3);
//		System.out.println(lfu.get(2));
//		System.out.println(lfu.get(3));
//		lfu.put(4, 4);
//		System.out.println(lfu.get(1));
//		System.out.println(lfu.get(3));
//		System.out.println(lfu.get(4));
		
//		LFUCache lfu = new LFUCache(0);
//		lfu.put(0, 0);
//		System.out.println(lfu.get(0));
		
		LFUCache lfu = new LFUCache(3);
		lfu.put(1, 1);
		lfu.put(2, 2);
		lfu.put(3, 3);
		lfu.put(4, 4);
		System.out.println(lfu.get(4));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(1));
		lfu.put(5, 5);
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(4));
		System.out.println(lfu.get(5));
	}
	
    HashMap<Integer, NodeLFU> map;
    int capacity, count;
    NodeLFU head, tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    	map = new HashMap<>();
    	head = new NodeLFU(0, 0, Integer.MAX_VALUE);
    	tail = new NodeLFU(0, 0, 0);
    	head.next = tail;
    	tail.pre = head;
    	head.pre = null;
    	tail.next = null;
    	count = 0;
    }
    
    public void deleteNode(NodeLFU node) {
    	node.pre.next = node.next;
    	node.next.pre = node.pre;
    }
    
    public void addToTail(NodeLFU node) {
    	node.next = tail;
    	node.pre = tail.pre;
    	tail.pre.next = node;
    	tail.pre = node;
    }
    
    public void heapify (NodeLFU node) {
    	while (node.pre.freq <= node.freq) {
    		NodeLFU prev = node.pre;
    		
    		prev.next = node.next;
    		node.pre = prev.pre;
    		node.pre.next = node;
    		prev.next.pre = prev;
    		node.next = prev;
    		prev.pre = node;
    	}
    }
    
    public int get(int key) {
        if (map.get(key) != null) {
        	NodeLFU node = map.get(key);
    		int result = node.value;
    		node.freq = node.freq+1;
    		heapify(node);
    		return result;
    	}
    	return -1;
    }
    
    public void put(int key, int value) {
        if (map.get(key) != null) {
        	NodeLFU node = map.get(key);
    		node.value = value;
    		node.freq = node.freq+1;
    		heapify(node);
    	} else {
    		NodeLFU node = new NodeLFU(key, value, 1);
    		if (count < capacity) {
    			count++;
    			map.put(key, node);
    			addToTail(node);
    			heapify(node);
    		} else if (capacity != 0) {
    			map.put(key, node);
    			map.remove(tail.pre.key);
    			deleteNode(tail.pre);
    			addToTail(node);
    			heapify(node);
    		}
    	}
    }
}

class NodeLFU {
    int key;
    int value;
    int freq;
    NodeLFU pre;
    NodeLFU next;
    
    public NodeLFU(int key, int value, int frequency) {
    	this.key = key;
    	this.value = value;
    	this.freq = frequency;
    }
}
