public class ContainerWater {
    public static void main(String[] args) {
        ContainerWater cw = new ContainerWater();
        System.out.println(cw.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        
        int left=0;
        int right = height.length-1;
        int maxWater = (right-left)*Math.min(height[left],height[right]);
        for(int len = right-1;len>0;len--){
           if(height[left]<height[right]) {
               left++;
           }else{
               right--;
           }
            maxWater = Math.max(maxWater,len * Math.min(height[left],height[right]));
        }
        return maxWater;
    }
}