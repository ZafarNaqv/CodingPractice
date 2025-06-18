import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] nums = {1,4,2,3,1,2};
        int k=3;
        System.out.println(new ContainsDuplicate2().containsNearbyDuplicate(nums,k));
    }
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int index =0;
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i, new ArrayList<>());
            }
            map.get(i).add(index++);
        }
        for(Map.Entry<Integer, ArrayList<Integer>> entry:map.entrySet()){
            if(entry.getValue().size()==2){
                int firstIndex = entry.getValue().get(0);
                int secondIndex = entry.getValue().get(1);
                if( Math.abs(firstIndex-secondIndex)<=k){
                    return true;
                }
            }else{
                if(entry.getValue().size()>2){
                    int currentIndex = 0;
                    for(int i:entry.getValue()){
                       for(int j=currentIndex+1;j<entry.getValue().size()-1;j++){
                           if(Math.abs(i-j)<=k){
                               return true;
                           }
                       }
                    }
                }
            }
        }
        return false;
    }
}