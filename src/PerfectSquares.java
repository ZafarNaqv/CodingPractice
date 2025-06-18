
import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }
    public int numSquares(int n) {
        int[] squares = new int[(int) Math.sqrt(n)+1];
        for(int i = 1; i < squares.length; i++) {
            squares[i] = i*i;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int j = 1; j <= n; j++) {
            for(int k = squares.length - 1; k >= 1; k--) {
                if(squares[k]<=j) {
                    dp[j] = Math.min(dp[j-squares[k]]+1,dp[j]);
                }else{
                    break;
                }
            }
        }
        return dp[n];
    }
}