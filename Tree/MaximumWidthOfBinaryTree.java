package tree;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {

	static int answer = 0;
    
    public static int widthOfBinaryTree(TreeNode root) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        doDfs(root, 0, 1, start, end);
        
        return answer;
    }
    
    public static void doDfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null) {
            return;
        }
        
        if(start.size() == level) {
            start.add(order);
            end.add(order);
        } else {
            end.set(level, order);
        }
        
        answer = Math.max(answer, end.get(level) - start.get(level) + 1);
        doDfs(root.left, level + 1, 2*order, start, end);
        doDfs(root.right, level + 1, 2*order + 1, start, end);
    }
}
