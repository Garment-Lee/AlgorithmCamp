package com.ligf.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Topic131
 * @Description 分割回文串
 * @Author Garment Lee
 * @Date 2021/4/15 14:39
 **/
public class Topic131 {

    public List<List<String>> partition(String s){
        //保存所有的分割方案，即分割后的字符串数组(全局使用)
        List<List<String>> res = new ArrayList<>();
        //保存一次分割方案(全局使用)
        List<String> path = new ArrayList<>();
        dfs(s, path, res);
        System.out.println("res:" + res.toString());
        return res;
    }

    public void dfs(String s, List<String> path, List<List<String>> res){

        //当分割的字符串为空字符串时，退出递归，一次分割完成
        if (s.isEmpty()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= s.length(); i ++){
            //切割字符串
            String preString = s.substring(0, i);
            //如果切割出来的字符串不是回文串，则返回，退出递归
            if (!isPalindrome(preString)){
                continue;
            }
            //如果是回文串，添加到path中
            path.add(preString);
            String dfsString = s.substring(i, s.length());
            dfs(dfsString, path, res);
            //执行回溯操作
            path.remove(path.size() - 1);
        }
    }

    /**
     * 验证是否是回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){

        String lowerCase = s.toLowerCase();
        int l = 0;
        int h = lowerCase.length() -1;
        while (l < h){
            while (l < h && !isValidChar(lowerCase.charAt(l))){
                l ++;
            }
            char left = lowerCase.charAt(l);
            while (l < h && !isValidChar(lowerCase.charAt(h))){
                h --;
            }
            char right = lowerCase.charAt(h);
            l ++;
            h --;
            if (left != right){
                return false;
            }
        }
        return true;
    }

    /**
     * 验证是否有效字符
     * @param res
     * @return
     */
    private boolean isValidChar(char res){
        if ((res >= 'a' && res <= 'z') || res >= '0' && res <= '9'){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Topic131 topic131 = new Topic131();
        topic131.partition("aab");
    }
}
