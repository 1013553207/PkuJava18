public class Solution {
    private  static int  INT_MAX = 2147483647;
    private  static int INT_MIN = -2147483648;

    public int maxProfit(int[] prices){
        int max=0, minV = INT_MAX;
        int diff;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<minV) minV = prices[i];
            diff = prices[i]-minV;
            if(diff > max)
                max = diff;
            }
    return max;
    }
}