public class Jumpable {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Jumpable().canJump(nums));
    }
    
    public boolean canJump(int[] nums) {
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
    }
}