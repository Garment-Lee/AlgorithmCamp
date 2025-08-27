package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic26
 * @Description 删除有序数组中的重复项
 * @Author GarmentLee
 * @Date 2025/6/25 16:16
 */
public class Topic26 {

    public static int removeDuplicates(int[] nums) {
        int i_val = 0;//当前前端遍历的元素值
        int j_val = 0;//当前后端遍历的元素值
        int k = 0;//返回的不重复的元素个数
        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            //先从数组前端开始遍历
            while (i <= j){
                if (i == 0){
                    i_val = nums[i];
                    i++;
                    k++;
                } else {
                    if (i_val == nums[i]){
                        break;
                    } else {
                        i_val = nums[i];
                        i++;
                        k++;
                    }
                }
            }
            //从数组尾端开始遍历
            while (i <= j){
                if (j == nums.length - 1){
                    j_val = nums[j];
                    j--;
                    continue;
                }
                if (nums[j] == j_val){
                    j--;
                } else {
                    nums[i] = j_val;//把尾部数据复制到前部重复处
                    j_val = nums[j];
                    k++;
                    i++;
                    break;
                }
            }
        }
        return k;
    }

    public static int removeDuplicatesV2(int[] nums) {
        int index = -1;
        int cmp_val = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i ++){
            if (i == 0){
                cmp_val = nums[i];
                k++;
                continue;
            }
            if (nums[i] == cmp_val){
                if (index < 0){
                    index = i;
                }
            } else {
                if (index > 0){
                    nums[index] = nums[i];
                    index++;
                }
                cmp_val = nums[i];
                k++;
            }
        }
        return k;
    }

        public static void main(String[] argS){
        int[] nums1 = {1,2};
        int result = removeDuplicatesV2(nums1);
        for (int i = 0; i < nums1.length; i ++){
            System.out.println("nums1[" + i+ "]:" + nums1[i]);
        }
        System.out.println("result:" + result);
    }

}
