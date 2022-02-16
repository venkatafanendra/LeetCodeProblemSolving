class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==1)
         return 0;
        int min_element = prices[0];
        int max_profit = prices[1]-min_element;
        for(int i=1;i<n;i++) {
            if(prices[i]<min_element)
                min_element=prices[i];
            if(prices[i]-min_element>max_profit)
                max_profit=prices[i]-min_element;
        }
        if(max_profit<0)
            return 0;
        else
            return max_profit; 
    }
}