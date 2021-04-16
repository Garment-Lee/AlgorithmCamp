package com.ligf.algorithm.leetcode.string;

/**
 * @ClassName Topic125
 * @Description 验证回文串，链接：https://leetcode-cn.com/problems/valid-palindrome/
 * @Author Garment Lee
 * @Date 2021/4/13 0:32
 **/
public class Topic125 {

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

    public static void main(String args[]){
        String s = "race a car";
        Topic125 topic125 = new Topic125();
        System.out.println("result: " + topic125.isPalindrome(s));
    }

}
