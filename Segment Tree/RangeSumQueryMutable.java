/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Note:

    The array is only modifiable by the update function.
    You may assume the number of calls to update and sumRange function is distributed evenly.

 * */

package segmenttree;

public class RangeSumQueryMutable {

	public static void main(String[] args) {
		int[] nums = {2,3,7,8,10,45,23,4,7,34,51,29};
		NumArray obj = new NumArray(nums);
		obj.update(5,23);
		System.out.println(obj.sumRange(2,9));
	}

}

class NumArray {

    class SegmentTree {
        
        int start, end;
        SegmentTree left, right;
        int sum;
        
        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
        
    }

    SegmentTree root = null;
    
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    public SegmentTree buildTree(int[] nums, int start, int end) {
        
        if (start > end) {
            return null;
        }
        
        SegmentTree ret = new SegmentTree(start, end);
        int sum = 0;
        
        if (start == end) {
            ret.sum = nums[start];
        } else {
            int mid = start + ((end-start)/2);
            ret.left = buildTree(nums, start, mid);
            ret.right = buildTree(nums, mid+1, end);
            ret.sum = ret.left.sum + ret.right.sum;
        }
        return ret;
    }

    void update(int i, int val) {
        update(root, i, val);
    }
    
    void update(SegmentTree node, int index, int value) {
        if (node.start == node.end) {
            node.sum = value;
            return;
        }
        
        int mid = node.start + (node.end-node.start)/2;
        
        if (index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }
        
        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    public int sumRange(SegmentTree node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.sum;
        }
        
        int mid = node.start + (node.end-node.start)/2;
        
        if(end <= mid) {
            return sumRange(node.left, start, end);
        } else if (start > mid) {
            return sumRange(node.right, start, end);
        } else {
            return sumRange(node.left, start, mid) + sumRange(node.right, mid+1, end);
        }
    }
}