import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class StoneWeights {
    public static void main(String[] args) {
        int[] arr = new int[]{9,14,10,65};
        System.out.println(new StoneWeights().lastStoneWeight(arr));
        System.out.println(new StoneWeights().lastStoneWeightHeap(arr));
    }
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        int[] newArray = Arrays.copyOf(stones,stones.length);
        while(newArray.length > 1){
            Arrays.sort(newArray);
            int diff = newArray[newArray.length-1] - newArray[newArray.length-2];
            if(diff > 0){
                newArray = Arrays.copyOf(newArray,newArray.length-1);
                newArray[newArray.length-1] = diff;
            }else{
                newArray = Arrays.copyOf(newArray,newArray.length-2);
            }
        }
        return newArray.length!=0?newArray[0]:0;
    }
    
    public int lastStoneWeightHeap(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones){
            maxHeap.add(i);
        }
        
        while(maxHeap.size() > 1){
            int maxWeight = maxHeap.poll();
            int secondMaxWeight = maxHeap.poll();
            if(maxWeight > secondMaxWeight){
                maxHeap.add(maxWeight - secondMaxWeight);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}