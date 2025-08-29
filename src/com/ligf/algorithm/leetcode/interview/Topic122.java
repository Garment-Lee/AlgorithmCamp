package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic122
 * @Description 买股票的最佳时机||
 * @Author GarmentLee
 * @Date 2025/8/29 16:08
 */
public class Topic122 {

    /**
     * 类似于动态规划算法
     * 设计思路：
     * 1）找到一个最小值（相对于后一个小）；
     * 2）判断卖出的节点：当前价格比最小值大，而且后一天的价格比当前价格低；
     * 3）卖出后，把后一天的价格作为最小值，继续进行步骤2）；
     * 4）最后一天也会执行卖出（临界点处理）；
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min_price){
                min_price = prices[i];
            } else {
                if (i == (prices.length - 1) || prices[i + 1] < prices[i]){
                    //卖出
                    max_profit += prices[i] - min_price;
                    //重置min_price，进行下一次买入卖出
                    min_price = Integer.MAX_VALUE;
                } else {
                    //不卖出，因为后一天的股价更高

                }
            }
        }
        return max_profit;
    }
}
