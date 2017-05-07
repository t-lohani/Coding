/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5. 
 * */

package heap;

public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int k = 5;
		System.out.println(findKthLargest(nums, k));
	}

	public static int[] heap;
	public static int counter;

    public static int findKthLargest(int[] nums, int k) {
        heap = new int[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            addElement(nums[i], i);
        }
        int answer = 0;
        
        for(int i=0; i<k; i++) {
            answer = deleteMax();
        }
        
        return answer;
    }
	
    public static void addElement(int num, int index) {
		heap[index] = num;
		counter++;
		int child = index;
		int parent;
		
		while(child>0) {
			parent = (child-1)/2;
			if(heap[parent]<heap[child]) {
				int temp = heap[parent];
				heap[parent] = heap[child];
				heap[child] = temp;
				child = parent;
			} else {
				break;
			}
		}
	}
	
	public static int deleteElement(int index) {
	    int element = heap[index];
		heap[index] = heap[counter-1];
		counter--;
		
		int child1, child2;
		while(true) {
			child1 = (index*2)+1;
			child2 = (index*2)+2;
			
			if(child1>=counter && child2>=counter) {
				break;
			} else if(child2>=counter) {
			    if(heap[index]<heap[child1]) {
			        int temp = heap[index];
    				heap[index] = heap[child1];
    				heap[child1] = temp;
    				index = child1;
			    } else {
			        break;
			    }
			} else {
				if(heap[index]<heap[child1] && heap[index]<heap[child2]) {
					int maxIndex = heap[child1]>heap[child2]?child1:child2;
					int temp = heap[index];
					heap[index] = heap[maxIndex];
					heap[maxIndex] = temp;
					index = maxIndex;
				} else if(heap[index]<heap[child1]) {
					int temp = heap[index];
					heap[index] = heap[child1];
					heap[child1] = temp;
					index = child1;
				} else if(heap[index]<heap[child2]) {
					int temp = heap[index];
					heap[index] = heap[child2];
					heap[child2] = temp;
					index = child2;
				} else {
					break;
				}
			}
		} 
		
		return element;
	}
	
	public static int deleteMax() {
		return deleteElement(0);
	}
}
