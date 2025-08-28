public class Jumpable {
    public static void main(String[] args) {
        int[] nums = {3,0,8,2,0,0,1};
        //   int[] nums = {2,3,1,1,4};
        System.out.println(new Jumpable().canJump(nums));
    }
    
    /*public boolean canJump(int[] nums) {
        int maxReach = 0;
        int index = 0;
        for (int currentNum : nums) {
            maxReach = Math.max(maxReach, currentNum + index);
            if (maxReach >= nums.length - 1) {
                return true;
            }
            if (maxReach <= index) {
                return false;
            }
            index++;
        }
        return false;
    }*/
    
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length==1){
            return true;
        }
        if(dp[0]==0){
            return false;
        }
        if(dp[0]>=nums.length-1){
           return true;
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],i+nums[i]);
            if(dp[i]>=nums.length-1){
                return true;
            }
            if(dp[i]==i && i!=nums.length-1){
                return false;
            }
        }
        return true;
    }
}