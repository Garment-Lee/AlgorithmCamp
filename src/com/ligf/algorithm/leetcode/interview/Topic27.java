package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic27[数组]
 * @Description 移除元素
 * @Author GarmentLee
 * @Date 2025/6/25 0:44
 * @解题思路
 * 1）不借助另外的工具记录数组中与val值相同的位置，我们需要在发现了对应的位置时就把与val不同的元素移到该位置；
 * 2）因为最后需要把与val不同的元素都放到数组前面，所以从数组头部开始遍历发现与val相同的元素，遍历游标为i；
 * 3）当从数组头部遍历时发现了与val相同的元素，跳转到从数组尾部开始遍历，遍历游标为j，寻找与val不同的元素，当找到之后，把与val不同的元素复制到前面与val相同的元素的位置；
 * 4）复制完之后，修改从头遍历的游标i和从尾遍历的游标j，然后返回到步骤2）；
 * 5）注意遍历的边界，也就是i=j的时候，跳出遍历，返回结果。
 */
public class Topic27 {

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        while (i <= j){
            while (i <= j){
                if (nums[i] == val){
                    break;
                } else {
                    i ++;
                    k++;
                }
            }
            while (i <= j){
                if (nums[j] == val){
                    j --;
                } else {
                    nums[i] = nums[j];
                    i ++;
                    j --;
                    k ++;
                    break;
                }
            }
        }
        return k;
    }

    public static void main(String[] argS){
        int[] nums1 = {2};
        int result = removeElement(nums1, 3);
        for (int i = 0; i < nums1.length; i ++){
            System.out.println("nums1[" + i+ "]:" + nums1[i]);
        }
        System.out.println("result:" + result);
    }

    }
