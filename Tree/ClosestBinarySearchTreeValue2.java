package tree;

import java.util.ArrayList;
import java.util.List;

public class ClosestBinarySearchTreeValue2 {

	public static void main(String[] args) {

	}

	static List<Integer> answer = new ArrayList<>();
    
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        inOrder(root, target, k);
        return answer;
    }
    
    public static void inOrder(TreeNode node, double target, int k) {
        if (node == null) {
            return;
        }
        
        inOrder(node.left, target, k);
        
        if (answer.size() < k) {
            answer.add(node.val);
        } else {
            double diff1 = Math.abs(target-answer.get(0));
            double diff2 = Math.abs(target-node.val);
            
            if (diff1 > diff2) {
                answer.remove(0);
                answer.add(node.val);
            }
        }
        
        inOrder(node.right, target, k);
    }
}
