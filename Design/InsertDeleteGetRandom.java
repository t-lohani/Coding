package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

	public static void main(String[] args) {
		RandomizedSet rs = new RandomizedSet();
		System.out.println(rs.insert(3));
		System.out.println(rs.insert(-2));
		System.out.println(rs.remove(2));
		System.out.println(rs.insert(1));
		System.out.println(rs.insert(-3));
		System.out.println(rs.insert(-2));
		System.out.println(rs.remove(-2));
		System.out.println(rs.remove(3));
		System.out.println(rs.insert(-1));
		System.out.println(rs.remove(-3));
		System.out.println(rs.insert(1));
		System.out.println(rs.insert(-2));
		System.out.println(rs.insert(-2));
		System.out.println(rs.insert(-2));
		System.out.println(rs.insert(1));
		System.out.println(rs.getRandom());
		System.out.println(rs.insert(-2));
		System.out.println(rs.remove(0));
		System.out.println(rs.insert(-3));
		System.out.println(rs.insert(1));
	}
}

class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int i = map.get(val);
            if (i != list.size()-1) {
                int last = list.get(list.size()-1);
                list.set(i, last);
                map.put(last, i);
            }
            
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}