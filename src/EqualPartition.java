public class EqualPartition {
    public static void main(String[] args) {
        int[] nums = {1,2,5};
        System.out.println(new EqualPartition().canPartition(nums));
    }
    
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int sumToFind = sum/2;
        boolean[] dp = new boolean[sumToFind+1];
        dp[0]=true;
        
        for(int num:nums){
            for(int i = sumToFind;i>=num;i--){
                if(dp[i-num]){
                    dp[i]=true;
                }
            }
        }
        return dp[sumToFind];
    }
}