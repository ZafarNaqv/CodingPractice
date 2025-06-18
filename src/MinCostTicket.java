import java.util.Arrays;

public class MinCostTicket {
    public static void main(String[] args) {
        int [] days = {1,4,6,7,8,20};
        int [] costs = {7,2,15};
        System.out.println(new MinCostTicket().CHATGPTmincostTickets(days,costs));
    }
    
    //Did this correctly without any help!!!!
        public int mincostTickets(int[] days, int[] costs) {
            int maxDays = -1;
            for(int i:days){
                maxDays = Math.max(maxDays,i);
            }
            int[] dp = new int[maxDays+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            boolean visitDay = false;
            int day = 0;
            for(int j=1;j<=maxDays;j++){
                for(int k=0;k<costs.length;k++){
                    if(j==days[day]) {
                        visitDay = true;
                        if(k==0) {
                            dp[j] = Math.min(dp[j], dp[j - 1] + costs[k]);
                        }else if(k==1 && j-7>=0 || j<7) {
                            if(j<7){
                                dp[j] = Math.min(dp[j], dp[0] + costs[k]);
                            }else {
                                dp[j] = Math.min(dp[j], dp[j - 7] + costs[k]);
                            }
                        }else if(k==2 && j-30>=0 || j<30){
                            if(j<30){
                                dp[j] = Math.min(dp[j], dp[0] + costs[k]);
                            }else {
                                dp[j] = Math.min(dp[j], dp[j - 30] + costs[k]);
                            }
                        }
                    }else{
                        dp[j] = dp[j-1];
                    }
                }
                if(visitDay){
                    day++;
                    visitDay = false;
                }
            }
            return dp[maxDays];
        }
    
    public int CHATGPTmincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1]; // Last travel day
        boolean[] travelDays = new boolean[maxDay + 1];
        for (int day : days) {
            travelDays[day] = true;
        }
        
        int[] dp = new int[maxDay + 1]; // DP array to store minimum cost up to day i
        for (int i = 1; i <= maxDay; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1]; // If not traveling on day i, cost stays the same
            } else {
                dp[i] = dp[i - 1] + costs[0]; // Buy 1-day pass
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]); // Buy 7-day pass
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]); // Buy 30-day pass
            }
        }
        
        return dp[maxDay];
    }
}