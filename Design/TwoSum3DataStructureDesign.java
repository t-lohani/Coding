package design;

import java.util.HashMap;
import java.util.Map;

public class TwoSum3DataStructureDesign {
	Map<Integer, Integer> map;
    public TwoSum3DataStructureDesign() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (value == 2*entry.getKey()) {
                if (entry.getValue() > 1)
                    return true;
            } else if (map.containsKey(value-entry.getKey())) {
                return true;
            }
        }
        
        return false;
    }
}
