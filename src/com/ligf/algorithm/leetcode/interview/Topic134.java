package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic134
 * @Description 加油站
 * 解决思路：
 * 1、遍历所有油站，当剩余油量大于等于0时，存在解；否则不存在，返回-1；
 * 2、因为题目描述中保证有解时有唯一的解，所以起始加油站应该是满足：
 * 1）gas[i]-cost[i]大于零；
 * 2）后面累计油量大于0
 *
 * 突破口：通过分析数据，找到存在唯一解时的条件，即可写出算法。
 * @Author GarmentLee
 * @Date 2025/9/7 16:07
 */
public class Topic134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = -1;
        int totalAccu = 0;
        int startIndexAccu = 0;
       for (int i = 0; i < gas.length; i++){
            int differVal = gas[i] - cost[i];
            if (differVal > 0 && startIndex < 0){//设置初始加油站
                startIndex = i;
            }
            totalAccu += differVal;
            startIndexAccu += differVal;
            if (startIndexAccu < 0){
                startIndex = -1;
                startIndexAccu = 0;
            }
       }
       if (totalAccu >= 0){
           return startIndex;
       } else {
           return -1;
       }
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println("result:" + result);
    }
}
