package com.ligf.algorithm.dynamicprogramming;

/**
 * @ClassName DynamicProgramming
 * @Description 钢条切割问题，链接：https://blog.csdn.net/u013309870/article/details/75193592
 * @Author Garment Lee
 * @Date 2021/4/12 15:53
 **/
public class DynamicProgramming {

    /**
     * 切割钢条
     * @param p 钢条的价格数组
     * @param n 钢条的长度
     * @return
     */
    public int cut(int[] p, int n){
        if (n == 0){
            return 0;
        }
        int q = 0;
        //i变量表示切割钢条左边的长度
        for (int i = 1; i <= n; i ++){
            q = Math.max(q, p[i - 1] + cut(p, n - i));
       }
        return q;
    }
}
