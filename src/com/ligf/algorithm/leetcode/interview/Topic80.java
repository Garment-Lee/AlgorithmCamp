package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic80
 * @Description 删除有序数组中的重复项ii
 * @Author GarmentLee
 * @Date 2025/8/27 10:45
 */
public class Topic80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int cmp_val = nums[0];//用于比较的值
        int index = 0;//有效数组的最后位置
        int dup_num_count = 1;//重复的数量
        int result_lgh = 1;//返回的最终有效长度
        for (int i = 1; i < nums.length; i++){
            if (cmp_val == nums[i]){
                dup_num_count ++;
                if (dup_num_count <= 2){
                    index ++;
                    nums[index] = nums[i];//把数据复制到有效位置
                    result_lgh ++;
                } else {
                    //直接跳过
                }
            } else {
                cmp_val = nums[i];
                dup_num_count = 1;
                index ++;
                nums[index] = nums[i];//把数据复制到有效位置
                result_lgh ++;
            }
        }
        return result_lgh;
    }
}
