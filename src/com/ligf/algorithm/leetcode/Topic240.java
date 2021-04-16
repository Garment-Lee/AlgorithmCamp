package com.ligf.algorithm.leetcode;


/**
 * @ClassName Topic240
 * @Description 题目：搜索二维矩阵||,链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/。
 *              要求：
 *              编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *              - 每行的元素从左到右升序排列。
 *              - 每列的元素从上到下升序排列。

 * @Author Garment Lee
 * @Date 2021/4/12 9:25
 **/
public class Topic240 {

    public boolean searchMatrix(int[][] matrix, int target){
        //行数
        int m = matrix.length;
        //列数
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]){
            return false;
        }

        int row = m - 1;
        int col = 0;

        while (row >= 0 && col <= n -1){
            if (target > matrix[row][col]){
                col ++;
            }
            if (target < matrix[row][col]){
                row --;
            }
            if (target == matrix[row][col]){
                return true;
            }
        }
        return false;
    }
}
