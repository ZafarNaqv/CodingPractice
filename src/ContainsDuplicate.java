import java.util.HashMap;

public class ContainsDuplicate {
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3, 1}));
    }
    
    public boolean containsDuplicate(int[] nums) {
        for(int num : nums){
            if(hashMap.containsKey(num)){
                return true;
            }else{
                hashMap.put(num,1);
            }
        }
        return false;
    }
}