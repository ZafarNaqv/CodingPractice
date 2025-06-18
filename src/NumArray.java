class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
    this.preSum = new int[nums.length];
    preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] =preSum[i-1]+ nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            return preSum[right];
        }
        return preSum[right] - preSum[left-1];
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,3,-5,2,-1};
        NumArray obj = new NumArray(nums);
        int left = 0;
        int right = 2;
        int param_1 = obj.sumRange(left,right);
        System.out.println(param_1);
    }
}