package com.ligf.algorithm.leetcode;

/**
 * @ClassName Topic136
 * @Description 136.只出现一次的数字
 *             给定一个非空整数数组，除了某个元素只出现一次意外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *             说明：算法应该具有线性时间复杂度，且不使用额外空间来实现。
 *             解决思路：
 *             使用异或的方法，异或具有交换律，a^0=a; a^a=0; a^b^a = a^a^b = b。
 * @Author Garment Lee
 * @Date 2021/4/9 15:40
 **/
public class Topic136 {

    public int singleNumber(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i ++){
            result = result ^ nums[i];
        }
        return result;
    }
}
