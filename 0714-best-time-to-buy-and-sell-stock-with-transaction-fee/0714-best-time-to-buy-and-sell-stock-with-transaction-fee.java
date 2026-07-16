class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash=0; //if sell
        int hold=-prices[0]; //if don't sell
        for(int i=1;i<prices.length;i++){
            int prevCash=cash;
            cash=Math.max(cash,hold+prices[i]-fee);
            hold=Math.max(hold,prevCash-prices[i]);
        }
        return cash;
    }
}