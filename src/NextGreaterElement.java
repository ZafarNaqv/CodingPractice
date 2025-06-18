import java.util.*;

public class NextGreaterElement {
    HashMap<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args) {
        NextGreaterElement runner = new NextGreaterElement();
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(runner.nextGreaterElement(nums1, nums2)));
    }
    private void  preproccessDataStructures(int[] nums2){
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        preproccessDataStructures(nums2);
        int resultIndex = 0;
        int[] result = new int[nums1.length];
        for(int numToFind:nums1){
            result[resultIndex] = map.getOrDefault(numToFind, -1);
            resultIndex++;
        }
        return result;
    }
}