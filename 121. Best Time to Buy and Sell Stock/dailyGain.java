class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2 ){
            return 0 ;
        }
        int[] dailyGain = new int[prices.length-1];
        for(int i = 0 ; i < dailyGain.length ; i++){
            dailyGain[i] = prices[i+1] - prices[i];
        }
        return lastProfit(dailyGain);
    }
    private int lastProfit(int[] dailyGain){
        int[] sumProfitArray = new int[dailyGain.length];
        sumProfitArray[0] = dailyGain[0] ;
        for (int i = 1 ; i < dailyGain.length ; i++){
            sumProfitArray[i] = Math.max(sumProfitArray[i-1]+dailyGain[i] , dailyGain[i]);
        }
        int max = 0 ;
        for(int i = 0 ; i < sumProfitArray.length ; i++){
            if(sumProfitArray[i] > max){
                max = sumProfitArray[i];
            }
        }
        return max;
    }
}
