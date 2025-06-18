public class DeleteAndEarn {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3};

        System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
    }
    
    public int deleteAndEarn(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        for(int i:nums){
            maxNum = Math.max(maxNum,i);
        }
        int[] dp = new int[maxNum+1];
        int[] points = new int[maxNum+1];
        for(int i:nums){
           points[i] = points[i]+i;
        }
        dp[1] = points[1];
        
        for(int i=2;i<=maxNum;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+points[i]);
        }
        
       return dp[maxNum];
    }
    
}