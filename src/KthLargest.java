import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9)); // Output: 8
        System.out.println(kthLargest.add(4)); // Output: 8
    }
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}