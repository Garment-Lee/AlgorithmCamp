package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic121
 * @Description 买卖股票的最佳时机
 * @Author GarmentLee
 * @Date 2025/8/28 23:53
 */
public class Topic121 {

    /**
     * 暴力法（轮询）
     * 缺点：数据量大的时候超时
      * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int max_profit = 0;
        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i + 1; j < prices.length; j++){
                max_profit = Math.max(max_profit, prices[j] - prices[i]);
            }
        }
        return max_profit;
    }

    /**
     * 动态规划版本算法
     * @param prices
     * @return
     */
    public int maxProfitV1(int[] prices){
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min_price){
                min_price = prices[i];
            } else {
                max_profit = Math.max(max_profit, prices[i] - min_price);
            }
        }
        return max_profit;
    }
}
