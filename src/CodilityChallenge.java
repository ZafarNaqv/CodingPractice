import java.util.TreeMap;

public class CodilityChallenge {
    public static void main(String[] args) {
        CodilityChallenge runner = new CodilityChallenge();
        int[] A ={-1,-3};
        System.out.println(runner.solution(A));
    }

    public int solution(int[] A) {
        TreeMap<Integer, Boolean> map = new TreeMap<>();
        for(int num:A){
            map.put(num,true);
        }

        for(int i=1;i<1_000_000;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return 1_000_000;



    }
}
