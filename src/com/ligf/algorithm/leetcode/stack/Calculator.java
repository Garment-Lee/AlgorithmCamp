package com.ligf.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName Calculator
 * @Description TODO
 * @Author GarmentLee
 * @Date 2025/4/19 10:43
 */
public class Calculator {

    /**
     * 先不考虑带括号的情况
     * @param expressionStr
     * @return
     */
    int calculateV1(String expressionStr){
        Stack<Integer> intStack = new Stack<Integer>();
        //缓存运算符
        Character tempOperator = '+';
        int num = 0;
        for (int i = 0; i < expressionStr.length(); i ++){
            char charObj = expressionStr.charAt(i);
            if (isDigit(charObj)){
                num = num * 10 + charObj - '0';
            } else {
                //第一个数先入栈
                if (intStack.size() == 0){
                    intStack.push(num);
                    tempOperator = charObj;
                    num = 0;
                    continue;
                }
                //如果前面是*或者是/的表达式，先算出结果，把结果入栈---start
                if ('*' == tempOperator){
                    int stackNum = intStack.pop();
                    intStack.push(stackNum * num);
//                    num = stackNum * num;
                } else if (  '/' == tempOperator){
                    int stackNum = intStack.pop();
                    intStack.push(stackNum / num);
//                    num = stackNum / num;
                }
                //如果前面是*或者是/的表达式，先算出结果，把结果入栈---end

                if (charObj == '+'){
                    int stackNum = intStack.pop();
                    intStack.push(stackNum + num);
                    num = 0;
                    tempOperator = '+';
                }
                if (charObj == '-'){
                    int stackNum = intStack.pop();
                    intStack.push(stackNum + num);
                    num = 0;
                    tempOperator = '-';
                }
                if (charObj == '*'){
                    if (tempOperator == '-'){
                        intStack.push(-num);
                    } else {
                        intStack.push(num);
                    }
                    num = 0;
                    tempOperator = '*';
                }
                if (charObj == '/'){
                    if (tempOperator == '-'){
                        intStack.push(-num);
                    }else {
                        intStack.push(num);
                    }
                    num = 0;
                    tempOperator = '/';
                }
            }
        }
        if (intStack.size() > 0){
            num = num + intStack.pop();
        }
        return num;
    }

    boolean isDigit(char charObj){
        if ((charObj - '0') >=0 && charObj - '0' <= 9){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        String expression = "2-3*4+5+2*2";
        Calculator calculator = new Calculator();
        int result = calculator.calculateV1(expression);
        System.out.println("result:" + result);
    }
}
