import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber runner = new MissingNumber();
       // System.out.println(runner.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(runner.missingNumberMathLogic(new int[]{9,6,4,2,3,5,7,0,1}));
    }
    
    public int missingNumberMathLogic(int[] nums) {
        int maxNum = nums.length;
        int i =0;
        int expectedSum =0;
        while(i<=maxNum){
            expectedSum += i;
            i++;
        }
        int actualSum = 0;
        for(int j=0;j<nums.length;j++){
            actualSum += nums[j];
        }
        System.out.printf("actualSum=%d, expectedSum=%d\n",actualSum,expectedSum);
        return expectedSum - actualSum;
    }
    
    
    public int missingNumber(int[] nums) {
        HashSet<Integer> numbersSeen = new HashSet<>();
        int maxNum = nums.length;
        for(int c : nums){
            numbersSeen.add(c);
        }
        int i=0;
        while(i<maxNum){
            if(!numbersSeen.contains(i)){
                return i;
            }
            i++;
        }
        return maxNum;
    }
}