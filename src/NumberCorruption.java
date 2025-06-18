import java.util.HashMap;

public class NumberCorruption {
    public static void main(String[] args) {
        int[] arr = new NumberCorruption().findErrorNums(new int[]{1,1});
        System.out.println(arr[0]+","+arr[1]);
    }
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer>  hashmap = new HashMap<>();
        int[] errorNums = new int[2];
        int twiceOccurrences = 1;
        int missing=-1;
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            hashmap.put(i,hashmap.getOrDefault(i,0)+1);
            max = Math.max(max,i);
        }
        for(int i=1;i<=max;i++){
            if(!hashmap.containsKey(i)){
                missing =i;
                continue;
            }
            if (hashmap.get(i) > 1) {
                twiceOccurrences = i;
            }
            
        }
        errorNums[0] = twiceOccurrences;
        errorNums[1] = missing==-1?max+1:missing;
        return errorNums;
    }
}