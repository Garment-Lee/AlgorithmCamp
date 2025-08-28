package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic189
 * @Description 轮转数组
 * @Author GarmentLee
 * @Date 2025/8/27 17:44
 */
public class Topic189 {

    /**
     * 方法1，当传入的是大数组时会超时
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int k_mod = k % nums.length;
        for (int i = 0; i < k_mod; i ++){
            int temp = nums[nums.length-1];
            for (int j = nums.length -1; j > 0; j --){
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 环状替换方法（一开始想到的方法，算法还可以优化）
     * @param nums
     * @param k
     */
    public static void rotateV2(int[] nums, int k){
        if (k == 0 || k == nums.length || nums.length == 1)
            return;
        int k_mod = k % nums.length;
        int start_index;
        int end_index;
        int temp_start;
        int temp_end;
        if (gcd(nums.length, k_mod) > 1){ //最大公约数大于1
            int loop = gcd(nums.length, k_mod);
            for (int i = 0; i < loop; i ++){
                start_index = i;
                temp_start = nums[i];
                for (int j = 0; j < nums.length/loop; j ++){
                    end_index = (start_index + k_mod) % nums.length;
                    temp_end = nums[end_index];
                    nums[end_index] = temp_start;
                    start_index = end_index;
                    temp_start = temp_end;
                }
            }
        } else {  //最大公约数为1
            start_index = 0;
            temp_start = nums[0];
            for (int i = 0; i < nums.length; i ++){
                end_index = (start_index + k_mod) % nums.length;
                temp_end = nums[end_index];
                nums[end_index] = temp_start;
                start_index = end_index;
                temp_start = temp_end;
            }
        }
    }

    /**
     * 对上一个算法进行优化
     * @param nums
     * @param k
     */
    public static void rotateV3(int[] nums, int k){
        if (k == 0 || k == nums.length || nums.length == 1)
            return;
        int k_mod = k % nums.length;
        int start_index;
        int end_index;
        int temp_start;
        int temp_end;
        int loop = gcd(nums.length, k_mod);
        for (int i = 0; i < loop; i ++){
            start_index = i;
            temp_start = nums[i];
            for (int j = 0; j < nums.length/loop; j ++){
                end_index = (start_index + k_mod) % nums.length;
                temp_end = nums[end_index];
                nums[end_index] = temp_start;
                start_index = end_index;
                temp_start = temp_end;
            }
        }
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int k = 2;
        rotateV3(nums, k);
        System.out.println("dcd:" + gcd(3,4));
    }
}
