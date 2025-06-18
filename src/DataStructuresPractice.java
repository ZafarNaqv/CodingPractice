import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DataStructuresPractice {
    // I need a data structure that takes in numbers and stores the number and returns the top 3
    // numbers in descending order i.e 4,3,6,1,7 so output should be: 7,6,4
    // and in reverse it should be 1,3,4
    public static void main(String[] args) {
       /*PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(4);
        maxHeap.add(3);
        maxHeap.add(6);
        maxHeap.add(1);
        maxHeap.add(7);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());*/
        
        
        //Return thirdMaximum
        int[] nums = {2,2,3,1};
        System.out.println(thirdMax(nums));
    }
    static void ascendingOrder(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(3);
        pq.add(6);
        pq.add(1);
        pq.add(7);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
    
    static int thirdMax(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i:nums){
            if(!hashSet.contains(i)){
                hashSet.add(i);
                maxHeap.add(i);
            }
        }
        
        int ans = maxHeap.poll();
        ans = maxHeap.peek()==null?ans:maxHeap.peek();
        maxHeap.poll();
        return maxHeap.peek()==null?ans:maxHeap.peek();
    }
}