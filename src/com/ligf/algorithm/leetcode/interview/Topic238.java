package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic238
 * @Description 除自身以外数组的乘积
 * 总结：
 * 1）left[i]数组保存i左边所有数据的乘积；
 * 2）right[i]数组保存i右边所有数据的乘积；
 * 3）result[i] = left[i] * right[i]；
 * @Author GarmentLee
 * @Date 2025/9/7 0:05
 */
public class Topic238 {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++){
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int j = nums.length - 2; j >=0; j ++){
            right[j] = right[j + 1];
        }
        for (int k = 0; k < nums.length; k++){
            result[k] = left[k] * right[k];
        }
        return result;
    }
}
