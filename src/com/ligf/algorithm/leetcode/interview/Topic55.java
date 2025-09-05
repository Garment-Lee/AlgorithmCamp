package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic55
 * @Description 跳跃游戏
 * @Author GarmentLee
 * @Date 2025/8/29 17:38
 */
public class Topic55 {

    public boolean canJump(int[] nums) {
        int max_jump_index = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0){
                if (i == 0 && nums.length > 1){
                    return false;
                }
                if (max_jump_index <= i && i != 0 && (i != nums.length - 1)){
                    return false;
                }
            }
            max_jump_index = Math.max(max_jump_index, i + nums[i]);
        }
        return true;
    }
}
