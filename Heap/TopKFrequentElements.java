package heap;

import java.util.ArrayList;
import java.util.List;


public class TopKFrequentElements {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,2,3,6,7,10,9,4,5,2,3,1,1,1,3,2,4,5,9,10};
		List<Integer> ans = topKFrequent(nums, 3);
		
		for (int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

    public static List<Integer> topKFrequent(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            if(min>nums[i]) {
                min = nums[i];
            }
            
            if(max<nums[i]) {
                max = nums[i];
            }
        }
        
        int[] countArr = new int[max-min+1];
        
        for(int i=0; i<nums.length; i++) {
            countArr[nums[i]-min]++;
        }
        
        heap = new Node[countArr.length];
        for(int i=0; i<countArr.length; i++) {
            addElement(countArr[i], i);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<k; i++) {
            answer.add(deleteMax().val + min);
        }
        
        return answer;
    }
    
    public static Node[] heap;
	public static int counter;
	
	public static void addElement(int num, int index) {
	    Node node = new Node(num, index);
		heap[index] = node;
		counter++;
		int child = index;
		int parent;
		
		while(child>0) {
			parent = (child-1)/2;
			if(heap[parent].freq<heap[child].freq) {
				Node temp = heap[parent];
				heap[parent] = heap[child];
				heap[child] = temp;
				child = parent;
			} else {
				break;
			}
		}
	}
	
	public static Node deleteElement(int index) {
	    Node element = heap[index];
		heap[index] = heap[counter-1];
		counter--;
		
		int child1, child2;
		while(true) {
			child1 = (index*2)+1;
			child2 = (index*2)+2;
			
			if(child1>=counter && child2>=counter) {
				break;
			} else if(child2>=counter) {
			    if(heap[index].freq<heap[child1].freq) {
			        Node temp = heap[index];
    				heap[index] = heap[child1];
    				heap[child1] = temp;
    				index = child1;
			    } else {
			        break;
			    }
			} else {
				if(heap[index].freq<heap[child1].freq && heap[index].freq<heap[child2].freq) {
					int maxIndex = heap[child1].freq>heap[child2].freq?child1:child2;
					Node temp = heap[index];
					heap[index] = heap[maxIndex];
					heap[maxIndex] = temp;
					index = maxIndex;
				} else if(heap[index].freq<heap[child1].freq) {
					Node temp = heap[index];
					heap[index] = heap[child1];
					heap[child1] = temp;
					index = child1;
				} else if(heap[index].freq<heap[child2].freq) {
					Node temp = heap[index];
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
	
	public static Node deleteMax() {
		return deleteElement(0);
	}
}

class Node {
    int freq;
    int val;
    
    public Node(int frequency, int value) {
        freq = frequency;
        val = value;
    }
}
