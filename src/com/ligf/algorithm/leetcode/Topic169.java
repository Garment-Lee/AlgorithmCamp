package com.ligf.algorithm.leetcode;

/**
 * @ClassName Topic169
 * @Description 多数元素。题目描述：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *              你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *              要求：时间复杂度为O(n)，空间复杂度为O(1)。
 *              解决思路：使用摩尔投票，前提是数组中存在多数元素。
 *
 * @Author Garment Lee
 * @Date 2021/4/12 1:00
 **/
public class Topic169 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i ++){
            if (count == 0){
                result = nums[i];
                count ++;
            } else {
                if (result == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }

        }
        return result;
    }
}
