import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * */
public class TwoSums {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int target = 6;
        int[] result = new TwoSums().twoSum(nums,target);
        System.out.println(result[0]+ ","+result[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int index=0;
        for(int i : nums){
            hashMap.put(i,index++);
        }
        int firstIndex =0;
        int secondIndex = 1;
        for(int i=0;i<nums.length;i++){
            firstIndex = i;
            int numbToFind = target - nums[firstIndex];
            for (int j=i+1;j<nums.length;j++){
                if(hashMap.containsKey(numbToFind)){
                    if(numbToFind == nums[firstIndex]){
                        for(int k=0;k<nums.length;k++){
                          if(nums[k]== numbToFind && k!=firstIndex){
                              return new int[]{firstIndex,k};
                          }
                       }
                       break;
                    }
                    secondIndex = hashMap.get(numbToFind);
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }
        return new int[]{firstIndex, secondIndex};

    }
}
