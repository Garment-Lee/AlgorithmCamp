package com.ligf.algorithm.dynamicprogramming;

/**
 * @ClassName StairProblem
 * @Description 阶梯问题
 * @Author GarmentLee
 * @Date 2025/8/26 0:09
 */
public class StairProblem {

    /**
     * n级楼梯，每次走1级或2级，有多少种走法
     * 问题分析：
     * 1）第一次走1级，然后剩下n-1级，则有f（n-1）种走法；
     * 2）第一次走2级，然后剩下n-2级，则有f（n-2）种走法；
     * 3）所以总共有f（n-1）+ f（n-2）种走法，可得f（n）=f（n-1）+f(n-2)
     * 算法设计：
     * 采用递归的算法，当n=1时，退出递归，返回1；当n=2时，退出递归返回2；
     * @param n
     * @return
     */
    public static int stair12(int n){
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int result = stair12(n - 1) + stair12(n - 2);
        return result;
    }

    /**
     * n级楼梯，每次走1级或2级或3级，有多少种走法
     * @param n
     * @return
     */
    public static int stair123(int n){
        //出现n=0是特殊情况，当剩余级数=3时，进入递归，就会出现n=0的情况（stair123(n-3)递归中出现）
        if (n == 0)
            return 1;
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
//        if (n == 3){
//            return 4;
//        }
        //总共的走法 = 第一次走1级后的走法 + 第一次走2级后的走法 + 第一次走3级后的走法
        //注意，当剩余的级数小于3时，下面的递归就会出问题，stair123(n-3)不能成立，因为级数不够3，无法一次走三级，需要直接返回结果值
        int result = stair123(n - 1) + stair123(n - 2) + stair123(n - 3);
        return result;
    }

    /**
     * n级楼梯，每次走1级或2级或3级，有多少种走法(第二种实现方法)
     * 这种写法是为了通用的算法而写的（即每次走1级或2级或M级）
     * @param n
     * @return
     */
    public static int start123V2(int n){
        int result = 0;
        if (n == 0){
            return 1;
        }
        if (n >= 3){
            for (int i = 1; i <=3; i++){
                result += start123V2(n - i);
            }
        } else if(n == 2){
            for (int i = 1; i <= 2;i++){
                result += start123V2(n - i);
            }
        } else if (n == 1){
            for (int i = 1; i <= 1;i++){
                result += start123V2(n - i);
            }
        }
        return result;
    }

    /**
     * n级楼梯，每次走1级或2级或3级或m级，有多少种走法（这是通用的算法）
     * 实现分析：
     * 1）多加一个参数m：代表一次走的级数；
     * 2）由于m是一个未知大小的数，所以可能存在m大于总楼梯数的情况，这时候最大走的级数不是m，而是n；
     * 3）当n>=m时，通过for循环累加每种级数的走法；
     * @param n
     * @param m
     * @return
     */
    public static int stairM(int n,int m){
        int result = 0;
        if (n == 0){
            return 1;
        }
        if (n >= m){
            for (int i = 1; i <=m; i++){
                result += stairM(n - 1, m);
            }
        } else {
            result += stairM(n, n);
        }
        return result;
    }

    public static void main(String[] args) {
        int result = stair123(3);
        System.out.println("result:" + result);
    }
}
