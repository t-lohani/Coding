/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
 * */

package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<List<Integer>> answer = new ArrayList<>();
    
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)
            return answer;
            
        List<Integer> list = new ArrayList<>();
        backtrack(root, sum, list);
        
        return answer;
    }
    
    public static void backtrack(TreeNode node, int remainingSum, List<Integer> list) {
        
        if(node.left==null && node.right==null) {
            
            if(remainingSum==node.val) {
                List<Integer> finalList = new ArrayList<>();
                list.add(node.val);
                for(Integer element : list) {
                    finalList.add(element);
                }
                
                answer.add(finalList);
                list.remove(list.size()-1);
            } else {
                return;
            }
        }
        
        if(node.left!=null) {
            list.add(node.val);
            backtrack(node.left, remainingSum-node.val, list);
            list.remove(list.size()-1);
        }
        
        if(node.right!=null) {
            list.add(node.val);
            backtrack(node.right, remainingSum-node.val, list);
            list.remove(list.size()-1);
        }
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
