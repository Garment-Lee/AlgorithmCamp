package com.ligf.algorithm.recurrence;

/**
 * @ClassName ReversedRecurrence
 * @Description 逆向递推（逆推）
 * @Author Garment Lee
 * @Date 2021/4/14 10:57
 **/
public class ReversedRecurrence {

    //存款月数
    int monthCount = 48;
    //保存每月剩余存款(第0个月到第48个月，共49个数)
    double[] money = new double[monthCount + 1];
    //每个月减少（取走）的额度
    int REDUCTION = 1000;
    //年利率
    double yearRate = 0.0171;
    //月利率
    double monthRate = yearRate / 12;

    /**
     * 求出每个月的剩余存款数，保存在数组中
     */
    public void recurrence(){
        //最后一个月剩余存款为1000
        money[48] = 1000;
        for(int i = monthCount; i > 0; i --){
            money[i -1] = money[i] / (1+ monthRate) + 1000;
        }
    }

    /**
     * 求出某个月的剩余存款数
     * @param n
     * @return
     */
    public double moneyInMonth(int n){
        double result = 1000;
        for (int i = monthCount; i > n; i --){
            result = result /(1 + monthRate) + 1000;
        }
        return result;
    }

    public void printMoney(){
        for (int i = 0; i < money.length; i ++){
            System.out.println("第" + i +"个月剩余存款为：" + money[i]);
        }
    }

    public static void main(String[] args){
        ReversedRecurrence reversedRecurrence = new ReversedRecurrence();
        reversedRecurrence.recurrence();
        reversedRecurrence.printMoney();

        System.out.println("monthInMonth 0:" + reversedRecurrence.moneyInMonth(0));
    }

}
