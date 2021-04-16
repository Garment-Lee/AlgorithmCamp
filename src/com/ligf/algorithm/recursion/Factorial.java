package com.ligf.algorithm.recursion;

/**
 * @ClassName Factorial
 * @Description 阶乘，实现思路：
 *              1）要算出n的阶乘f(n)，先算出n-1的阶乘f(n-1)，f(n)=n*f(n-1)；
 *              2）要算出n-1的阶乘f(n-1)，先算出n-2的阶乘f(n-2)，f(n-1) = (n-1) * f(n-2)；
 *              3）依次类推...
 *              4）当n=1时，f(1) = 1;
 *              第四步作为递归的退出条件，前面的几步分析，把问题转换为解决范围更小的子问题。
 * @Author Garment Lee
 * @Date 2021/4/8 22:07
 **/
public class Factorial {

    /**
     * 递归实现阶乘
     * @param n
     * @return
     */
    public int factorial(int n){
        if (n == 1)
            return 1;
        int result = n * factorial(n - 1);
        return result;
    }


}
