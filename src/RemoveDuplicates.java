import java.util.Arrays;

/*
*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
* such that each unique element appears only once. The relative order of the
*  elements should be kept the same. Then return the number of unique elements in nums.
**/
public class RemoveDuplicates {
    int[] array;
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates obj = new RemoveDuplicates();
        int  result = obj.removeDuplicatesOptimised(nums);
        //int[]  result = new RemoveDuplicates().shiftArrayToLeft(nums,1,0);
        System.out.println(result);
        System.out.println(Arrays.toString(obj.array));
    }
    public int removeDuplicates(int[] nums) {
        int currentMax = nums[0];
        int uniqueElements=1;
        int repeatedOccurence = 0;
        for(int i =1;i<nums.length;i++){
            if(nums[i]==Integer.MIN_VALUE){
                break;
            }
            if(nums[i]==currentMax){
                repeatedOccurence++;
            }else{
                uniqueElements++;
                currentMax = nums[i];
                int startIndex = i-repeatedOccurence;
                nums = shiftArrayToLeft(nums,repeatedOccurence,startIndex);
                i=startIndex;
                repeatedOccurence = 0;
            }
        }
        this.array = nums;
        return uniqueElements;
    }

    private int[] shiftArrayToLeft(int[] nums,int repeatedOccurence,int startIndex) {
        int shifted=0;
        while(shifted!=repeatedOccurence){
            for(int j=startIndex;j<nums.length-1;j++) {
                nums[j] = nums[j + 1];
            }
            shifted++;
            nums[nums.length-1]=Integer.MIN_VALUE;
        }
        return nums;
    }
    public int removeDuplicatesOptimised(int[] nums) {
        int cnt=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                nums[cnt++]=nums[i];
            }
        }
        this.array=nums;
        return cnt;
    }
}
