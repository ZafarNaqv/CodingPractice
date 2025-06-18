import java.util.HashMap;

public class ClimbStairs {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static {
        map.put(1,1);
        map.put(2,2);
    }
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(45));

    }
    public int climbStairs(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
       // System.out.println(n);
        if(n<3){
            return map.get(n);
        }else{
            int result = climbStairs(n-1)+climbStairs(n-2);
            map.put(n,result);
        }
        return map.get(n);
    }
}
