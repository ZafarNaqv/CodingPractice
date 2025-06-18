public class KadaneAlgo {
    public static void main(String[] args) {
        KadaneAlgo runner = new KadaneAlgo();
        int[] nums = {5,4,-1,7,8};
        //int[] nums = {-2,1,-3,4};
        System.out.println(runner.maxSubArray(nums));
    }
    
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currentSum = 0;
        for (int num : nums) {
            currentSum = Math.max(currentSum + num, num);
            
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}