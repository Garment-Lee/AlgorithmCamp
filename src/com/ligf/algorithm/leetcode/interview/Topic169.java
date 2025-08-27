package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic169
 * @Description 多数元素
 * @Author GarmentLee
 * @Date 2025/8/27 17:04
 */
public class Topic169 {

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i ++){
            if (candidate == nums[i]){
                count ++;
            } else {
                if (count > 0){
                    count --;
                } else {
                    count = 1;
                    candidate = nums[i];
                }
            }
        }
        return candidate;
    }
}
