import java.util.Arrays;

/**
 You are given a large integer represented as an integer array digits, where each digits[i]
 is the ith digit of the integer. The digits are ordered from most significant to least
 significant in left-to-right order. The large integer does not contain any leading 0's.
 Increment the large integer by one and return the resulting array of digits.
 * */
//TODO: CANT SOLVE THIS
public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {8,9};
        int [] result = new PlusOne().plusOne(nums);
        System.out.println(Arrays.toString(result));
    }
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]+1<=9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        digits = new int[digits.length+1];
        digits[0]=1;

        return digits;
    }
}
