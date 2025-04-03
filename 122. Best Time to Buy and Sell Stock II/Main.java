class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int cost = prices[0];
        for(int price : prices){
            if(price - cost > 0){
                res += price - cost;
                cost = price;
            }
            else{
                cost = Math.min(cost, price);
            }
        }
        return res;
    }
}
