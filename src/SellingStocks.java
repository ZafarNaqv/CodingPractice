import java.util.Arrays;

public class SellingStocks {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(new SellingStocks().maxProfitUnoptimised(prices));
        System.out.println(new SellingStocks().maxProfitOptimised(prices));
    }
    public int maxProfitUnoptimised(int[] prices) {
        int profit = 0;
        for(int split =1;split<prices.length;split++){
            int[] leftarr = Arrays.copyOfRange(prices,0,split);
            int[] rightarr = Arrays.copyOfRange(prices,split,prices.length);
            int buyPrice = computeBuyPrice(leftarr);
            int sellPrice = computeSellPrice(rightarr);
            profit= Math.max(profit,sellPrice-buyPrice);
        }
        return profit;
    }

    private int computeSellPrice(int[] rightarr) {
        int maxPrice = Integer.MIN_VALUE;
        for(int i:rightarr){
            maxPrice = Math.max(maxPrice,i);
        }
        return maxPrice;
    }

    private int computeBuyPrice(int[] leftarr) {
        int minPrice = Integer.MAX_VALUE;
        for(int i:leftarr){
            minPrice = Math.min(minPrice,i);
        }
        return minPrice;
    }

    public int maxProfitOptimised(int[] prices) {
        int N = prices.length;
        int[] minPriceLeft = new int[N];
        int[] maxPriceRight = new int[N];

        minPriceLeft[0]= prices[0];
        for(int i = 1;i<N;i++){
            minPriceLeft[i] = Math.min(minPriceLeft[i-1],prices[i]);
        }

        maxPriceRight[N-1]= prices[N-1];
        for(int i = N-2;i>=0;i--){
            maxPriceRight[i] = Math.max(maxPriceRight[i+1],prices[i]);
        }

        int maxProfit =0;
        for(int split = 0;split<N-1;split++){
            maxProfit = Math.max(maxProfit,maxPriceRight[split]-minPriceLeft[split]);
        }
        return maxProfit;


    }
    
    public static int chatGPTLogic(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
}