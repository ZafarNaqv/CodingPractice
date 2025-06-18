import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MajorityElement {
    
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,6};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
    
    //Java 7
    public int majorityElementJava7(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null");
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int majorityElement = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
    
    //Java 8
    public int majorityElement(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(groupingBy(num -> num, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("No majority element found"));
    }
   
    
    
}