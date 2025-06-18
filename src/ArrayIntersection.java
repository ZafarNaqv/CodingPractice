import java.util.*;

public class ArrayIntersection {
    public static void main(String[] args) {
        ArrayIntersection runner = new ArrayIntersection();
        System.out.println(Arrays.toString(runner.intersect(new int[]{2}, new int[]{1,2,2,1})));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nums1Map = new HashMap<>();
        HashMap<Integer,Integer> nums2Map = new HashMap<>();
        
        for(int i:nums1){
            nums1Map.put(i,nums1Map.getOrDefault(i,0)+1);
        }
        
        for(int i:nums2){
            nums2Map.put(i,nums2Map.getOrDefault(i,0)+1);
        }
        
        List<Integer> result = new ArrayList<>();
        int intersection;
        for(Map.Entry<Integer,Integer> nums1Entry:nums1Map.entrySet()){
            
                if (nums2Map.containsKey(nums1Entry.getKey())) {
                    intersection = Math.min(nums2Map.get(nums1Entry.getKey()), nums1Entry.getValue());
                    for (int count = 0; count < intersection; count++) {
                        result.add(nums1Entry.getKey());
                    }
                    
                }
            
        }
        return new HashSet<>(result).stream().mapToInt(i->i).toArray();
       // return result.stream().mapToInt(i->i).toArray();
        
    }
}