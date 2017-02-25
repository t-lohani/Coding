/*
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000. 
 * */

package tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {

	public static void main(String[] args) {
		
	}

	public static int answer = 0;
	
    public static int pathSum(TreeNode root, int sum) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        recurse(root, sum, map, 0);
        
        return answer;
    }
    
    public static void recurse(TreeNode node, int target, Map<Integer, Integer> map, int currSum) {
        if (node == null) {
            return;
        }
        
        currSum += node.val;
        
        if (map.containsKey(currSum - target)) {
            answer += map.get(currSum - target);
        }
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        recurse(node.left, target, map, currSum);
        recurse(node.right, target, map, currSum);
        
        map.put(currSum, map.get(currSum) - 1);
    }
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}