package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

	public static void main(String[] args) {
		List<List<Integer>> wall = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);
		wall.add(list);
		list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		wall.add(list);
		list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		wall.add(list);
		list = new ArrayList<>();
		list.add(2);
		list.add(4);
		wall.add(list);
		list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		wall.add(list);
		list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(1);
		list.add(1);
		wall.add(list);
		
		System.out.println(leastBricks(wall));
	}

	public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        
        for (int i=0; i<wall.size(); i++) {
            int len = 0;
            List<Integer> list = wall.get(i);
            for (int j=0; j<list.size()-1; j++) {
                len += list.get(j);
                int val = map.getOrDefault(len, 0);
                map.put(len, val+1);
                answer = Math.max(answer, val+1);
                if (answer == wall.size())
                    return 0;
            }
        }
        
        return wall.size()-answer;
    }
}
