package design;

import java.util.HashMap;

public class LRUCache {
    
	public static void main (String args[]) {
		LRUCache lru = new LRUCache(3);
		lru.set(1, 1);
		lru.set(2, 2);
		lru.set(3, 3);
		lru.set(4, 4);
		System.out.println(lru.get(4));
		System.out.println(lru.get(3));
		System.out.println(lru.get(2));
		System.out.println(lru.get(1));
	}
	
    HashMap<Integer, NodeLRU> map;
    int capacity, count;
    NodeLRU head, tail;
    
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	map = new HashMap<>();
    	head = new NodeLRU(0, 0);
    	tail = new NodeLRU(0, 0);
    	head.next = tail;
    	tail.pre = head;
    	head.pre = null;
    	tail.next = null;
    	count = 0;
    }
    
    public void deleteNode(NodeLRU node) {
    	node.pre.next = node.next;
    	node.next.pre = node.pre;
    }
    
    public void addToHead(NodeLRU node) {
    	node.next = head.next;
    	node.next.pre = node;
    	node.pre = head;
    	head.next = node;
    }
    
    public int get(int key) {
    	if (map.get(key) != null) {
    		NodeLRU node = map.get(key);
    		int result = node.value;
    		deleteNode(node);
    		addToHead(node);
    		return result;
    	}
    	return -1;
    }
    
    public void set(int key, int value) {
    	if (map.get(key) != null) {
    		NodeLRU node = map.get(key);
    		node.value = value;
    		deleteNode(node);
    		addToHead(node);
    	} else {
    		NodeLRU node = new NodeLRU(key, value);
    		map.put(key, node);
    		if (count < capacity) {
    			count++;
    			addToHead(node);
    		} else {
    			map.remove(tail.pre.key);
    			deleteNode(tail.pre);
    			addToHead(node);
    		}
    	}
    }
}

class NodeLRU {
    int key;
    int value;
    NodeLRU pre;
    NodeLRU next;
    
    public NodeLRU(int key, int value) {
    	this.key = key;
    	this.value = value;
    }
}