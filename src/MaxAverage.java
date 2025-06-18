public class MaxAverage {
    public static void main(String[] args) {
        MaxAverage ma = new MaxAverage();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(ma.findMaxAverage(nums,4));
    }
    
    public double findMaxAverage(int[] nums, int k) {
        int maxSum;
        int currentSum = 0;
        for(int i=0;i<k;i++){
            currentSum+=nums[i];
        }
        maxSum = currentSum;
        for(int j=k;j<nums.length;j++){
            currentSum+=nums[j];
            currentSum-=nums[j-k];
            maxSum = Math.max(maxSum,currentSum);
        }
        return (double) maxSum/k;
        
    }
}