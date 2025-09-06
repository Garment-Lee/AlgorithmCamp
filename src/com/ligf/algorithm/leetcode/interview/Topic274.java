package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic274
 * @Description H指数
 * 实现思路：
 * 1）h指数：统计数组中大于某个数h的个数count，需要count大于或等于h，最大的h就是h指数
 * 2）h指数最大是数组的长度length（当所有的数都大于等于length的时候）；
 * 3）新建一个数组temp，用于保存数组中某个数的出现次数（citations数组的值作为temp数组的下标，temp数组的值对应该下标值在citations数组中的个数）；
 * 4）遍历数组citations，大于等于length的数单独统计，其他统计保存到temp数组中；
 * 5）遍历temp数组，统计大于某个数a的个数count，当count大于等于a时，a就是h指数。
 * 总结：
 * 本算法实现的突破点是用数组保存另一个数组中数据出现的次数。
 * @Author GarmentLee
 * @Date 2025/9/5 23:58
 */
public class Topic274 {

    public int hIndex(int[] citations) {
        int length = citations.length;
        //citations数组的值作为temp数组的下标，temp数组的值对应该下标值在citations数组中的个数，
        // 比如temp[1]保存1在citations数组中1出现的次数
        int[] temp = new int[length];
        int bigCount = 0;
        for (int i = 0; i < length; i++){
            if (citations[i] >= length){
                bigCount++;
            } else {
                //统计citations[i]出现的次数
                int tempIndex = citations[i];
                temp[tempIndex]++;
            }
        }
        if (bigCount == citations.length){
            return bigCount;
        } else {
            for (int i = length - 1; i >= 0; i --){
                bigCount = bigCount + temp[i];
                if (bigCount >= i){
                    return i;
                }
            }
        }
        return bigCount;
    }
}
