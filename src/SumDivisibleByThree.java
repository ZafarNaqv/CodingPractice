public class SumDivisibleByThree {
    
    public static void main(String[] args) {
        int nums[] = {2,6,2,2,7};
        System.out.println(new SumDivisibleByThree().maxSumDivThree(nums));
    }
    
    
    public int maxSumDivThree(int[] nums) {
        int sum =0;
        int min1 = Integer.MAX_VALUE;
        int min1_2 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min2_2 = Integer.MAX_VALUE;
        for(int num : nums){
            sum += num;
            if(num%3 == 1){
                if(num<min1){
                    min1_2 = min1;
                    min1 = num;
                }else if(num<min1_2){
                    min1_2 = num;
                }
            }
            if(num%3 == 2){
                if(num<min2){
                    min2_2 = min2;
                    min2 = num;
                }else if(num<min2_2){
                    min2_2 = num;
                }
            }
        }
        if(sum%3 == 0){
            return sum;
        }else if(sum%3 == 1){
            if(min2!=Integer.MAX_VALUE && min2_2!=Integer.MAX_VALUE){
                return sum - Math.min(min1,min2+ min2_2);
            }
            return sum - min1;
        }else{
            if(min1!=Integer.MAX_VALUE && min1_2!=Integer.MAX_VALUE){
                return sum - Math.min(min2,min1+min1_2);
            }
            return sum - min2;
        }
    }
}