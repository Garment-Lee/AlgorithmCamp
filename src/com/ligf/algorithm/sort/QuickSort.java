package com.ligf.algorithm.sort;

/**
 * @ClassName QuickSort
 * @Description 快速排序。
 *              思路：使用分治的思想，
 *              1）以数组的第一个数为基数key，对数组进行排序，把数组分为左边是小于基数key部分，右边是大于基数key部分；
 *              2）对左边的数组执行步骤1的操作（解决规模更小的子问题，递归）；
 *              3）对右边的数组执行步骤1的操作（解决规模更小的子问题，递归）；
 *              4）设置递归的退出条件。
 * @Author Garment Lee
 * @Date 2021/4/11 17:15
 */
public class QuickSort {

    public void quickSort(int l, int h, int[] arr){
        while (l < h){
            int i = l;
            int j = h;
            int key = arr[0];
            while (i < j){
                while (i < j && arr[j] > key){
                    j --;
                }
                if (i < j){
                    arr[i] = arr[j];
                    i ++;
                }
                while (i < j && arr[i] < key){
                    i ++;
                }
                if (i < j){
                    arr[j] = arr[i];
                    j --;
                }
            }
            arr[i] = key;
            //递归执行规模更小的左边数组
            quickSort(l, i - 1, arr);
            //递归执行规模更小的右边数组
            quickSort(i + 1, h, arr);
        }
    }
}
