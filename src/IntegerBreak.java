public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(8));
    }
    
    //WHat an awesome code, done it but took some time!
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j = 1; j <= (i/2); j++) {
                dp[i] = Math.max(dp[i - j] * j,dp[i]);
                dp[i] = Math.max((i - j)* j,dp[i]);
            }
          
        }
        return dp[n];
    }
    //THIS FORMULA NEEDS TO BE MODELED dp[i]=max(dp[i],j×(i−j),j×dp[i−j])
    public int CHATGPTintegerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[1] = 1;
        
        // Fill dp array for every number from 2 to n
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));        // Split i into j and (i - j)
                dp[i] = Math.max(dp[i], j * dp[i - j]);      // Split i into j and the best product of (i - j)
            }
        }
        
        return dp[n];
    }
}