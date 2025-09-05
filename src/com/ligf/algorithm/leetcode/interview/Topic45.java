package com.ligf.algorithm.leetcode.interview;

/**
 * @ClassName Topic45
 * @Description 跳跃游戏||
 * 分析：这是典型的贪心算法，通过局部最优解得到全局最优解
 * @Author GarmentLee
 * @Date 2025/9/5 10:36
 */
public class Topic45 {

    /**
     * 这是第一次想出来的算法，从数组尾部向前遍历
     * 思路如下：
     * 1）想要以最少得跳跃次数达到n-1的位置，那最后一次的跳跃必须是跨步最大的，向前遍历找到跨步最大的跳跃；
     * 2）依次类推，倒数第二次的跳跃也必须是跨步最大的，向前遍历找到跨步最大的；
     * 3）直到遍历到位置为0的位置；
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int last_index = nums.length - 1;//跳跃开始的位置，从数组最后的位置开始
        int max_last_index = last_index;//能够跳跃一次达到last_index的位置
        int result = 0;
        while (max_last_index > 0){
            for (int i = last_index - 1; i >= 0; i--){
                if ((i + nums[i]) >= last_index){
                    max_last_index = i;
                }
            }
            //找到最大的能够跳跃一次到达last_index的位置，算是一次跳跃
            result ++;
            //重置跳跃开始位置last_index为max_last_index,开启下一次轮询查找
            last_index = max_last_index;
        }
        return result;
    }

    /**
     * 正向查找（第二种算法）
     * 实现思路：
     * 以{2,3,1,1,4}数组为例子
     * 1）从位置0开始，可以达到位置1或者位置2，到达位置1可以跳跃3级，到达位置2可以跳跃1级，选择跳跃到位置1；
     * 2）代码级别：遍历数组，找到每个可达位置中能实现最大跳跃的位置；
     * 3）已上一次找到的最大跳跃位置为初始位置，继续执行步骤1）
     * @param nums
     * @return
     */
    public static int jumpV2(int[] nums){
        int max_step = 0;
        int end = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i ++){
            max_step = Math.max(max_step, nums[i] + i);
            if (i == end){
                end = max_step;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int result = jump(nums);
        System.out.println("result:" + result);
    }
}
