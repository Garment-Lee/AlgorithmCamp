package com.ligf.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Topic46
 * @Description 全排序，链接：https://leetcode-cn.com/problems/permutations/
 * @Author Garment Lee
 * @Date 2021/4/13 16:53
 **/
public class Topic46 {

    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        //保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }

        //保存元素是否被使用的标记
        boolean[] isUsed = new boolean[len];
        //保存一个排序
        List<Integer> path = new ArrayList<>();
        //深度遍历
        dfs(nums, len, 0, path, isUsed, res);
        return res;
    }

    /**
     *  深度遍历
     * @param nums 待遍历的数组元素
     * @param len 排列的长度
     * @param depth 当前遍历时排列的长度
     * @param path 保存排列
     * @param isUsed 保存数组元素是否已经被使用的标志
     * @param res 用于保存遍历完毕的所有排列
     */
    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] isUsed, List<List<Integer>> res){

        //递归遍历退出条件
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        //遍历数组元素
        for (int i = 0; i < len; i ++){
            if (!isUsed[i]){
                path.add(nums[i]);
                isUsed[i] = true;

                dfs(nums, len, depth + 1, path, isUsed, res);
                //回溯操作，从深层结点回到浅层结点的过程
                isUsed[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args){

    }
}
