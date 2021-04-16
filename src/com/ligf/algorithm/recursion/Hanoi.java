package com.ligf.algorithm.recursion;

/**
 * @ClassName Hanoi
 * @Description 汉诺塔问题，n个盘子，A，B，C三个柱子，盘子从小到大叠在A柱上，把盘子搬到C柱上，B柱作为中间暂存柱。分析思路：
 *              1）先把n-1个盘子从A搬到B；
 *              2）把最大（最底下）一个盘子从A帮到C；
 *              3）再把n-1个盘子从B搬到C；
 *              其中，第一步和第三步搬的次数是一样的，即为h(n-1)，则h(n) = h(n-1) + 1 + h(n-1)。
 *              可以看出，这是一个递归的算法，跳出递归的条件是当n=1，h(1)=1;问题与子问题的关系是h(n) = h(n-1) + 1 + h(n-1)。
 * @Author Garment Lee
 * @Date 2021/4/8 22:13
 **/
public class Hanoi {

    String from = "A";
    String helper = "B";
    String to = "C";

    /**
     * 盘子的移动
     * @param n
     * @param from
     * @param helper
     * @param to
     * @return
     */
    public int move(int n, String from, String helper, String to){
        if (n == 1)
            return 1;

        //第一步，先把n-1个盘子从A搬到B
        int moveCount1 = move(n -1, from, to, helper);
        //第二步，再把最底下的盘子重A搬到C
        int moveCount2 = move(1, from, helper, to);
        //第三步，最后把n-1个盘子从B搬到C
        int moveCount3 = move(n - 1, helper, from, to);
        //返回总的移动步数
        int totalMoveCount = moveCount1 + moveCount2 + moveCount3;
        return totalMoveCount;
    }
}
