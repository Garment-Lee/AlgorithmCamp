package com.ligf.algorithm.recurrence;

/**
 * @ClassName Fibonacci
 * @Description 斐波那契数列的递推版本，f(n)=f(n-1) + f(n-2)
 * @Author Garment Lee
 * @Date 2021/4/14 16:47
 **/
public class Fibonacci {

    /**
     * 递推版斐波那契数列的实现
     * @param n
     * @return
     */
    public int fibonacci(int n){
        if (n == 1){
            return 1;
        }
        int f_n_1 = 1;
        int f_n_2 = 0;
        int f_n = 0;
        for (int i = 1; i < n; i ++){
            f_n = f_n_1 + f_n_2;
            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }
        return f_n;
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("n = 4 :" + fibonacci.fibonacci(4));
        System.out.println("n = 5 :" + fibonacci.fibonacci(5));
        System.out.println("n = 6 :" + fibonacci.fibonacci(6));
    }
}
