package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic88
 * @Description 合并两个有序数组
 * @Author GarmentLee
 * @Date 2024/9/5 23:34
 */
public class Topic88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 && n > 0){
            for(int i = 0; i < n; i ++){
                nums1[i] = nums2[i];
            }
        } else if(m > 0 && n > 0){
            for(int i = (n + m -1); i >= 0; i --){
                if (m==0 && n == 0){
                    return;
                }
                if (n <= 0 && m >= 1){
                    nums1[i] = nums1[m-1];
                    m --;
                } else if (m <= 0 && n >= 1){
                    nums1[i] = nums2[n-1];
                    n --;
                } else if(nums2[n-1] >= nums1[m-1]){
                    nums1[i] = nums2[n-1];
                        n --;
                } else {
                    nums1[i] = nums1[m-1];
                    m --;
                }
            }
        }
    }

    public static void main(String[] argS){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i ++){
            System.out.println("nums1[" + i + "]:" + nums1[i]);
        }
    }
}
