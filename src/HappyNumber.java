import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    Set<Integer> numbersSeen = new HashSet();
    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(2));
    }
    public boolean isHappy(int n) {
        while(!numbersSeen.contains(n)){
            if(n==1){
                return true;
            }
            numbersSeen.add(n);
            n = digitSum(n);

        }
        return false;
    }

    private int digitSum(int num){
        char[] digits = String.valueOf(num).toCharArray();
        int sum =0;
        for(int i=0;i<digits.length;i++){
            sum+=Math.pow(digits[i]- '0',2);
        }
      //  System.out.println(sum);
        return sum;
    }
}
