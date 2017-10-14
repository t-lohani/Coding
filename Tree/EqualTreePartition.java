package tree;

import java.util.HashMap;
import java.util.Map;

public class EqualTreePartition {

	static Map<Integer, Integer> map;
	static int sum = 0;
    
    public static boolean checkEqualTree(TreeNode root) {
        map = new HashMap<>();
        postOrder(root);
        if (sum == 0)
            return map.getOrDefault(sum, 0) > 1;
        return sum%2 == 0 && map.containsKey(sum/2);
    }
    
    public static int postOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int add = node.val +postOrder(node.left) + postOrder(node.right); 
        map.put(add, map.getOrDefault(add, 0) + 1);
        sum += node.val;
        return add;
    }
}
