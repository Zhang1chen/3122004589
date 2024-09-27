package HomeWork2;

import java.io.IOException;

public static void main(String[] args) {
//        先测试10个例子看看
    int numberQuestions = 10;
    int range = 10;
    if (numberQuestions == 0) {
        System.out.println("错误:使用 -n 参数控制生成题目的个数");
        return;
    }
    if (range == 0) {
        System.out.println("错误:使用 -r 参数控制题目中数值（自然数、真分数和真分数分母）的范围");
//            遇到错误直接结束
        return;
    }
//        makeQuestions(numberQuestions,range);
    try {
        makeQuestions(numberQuestions, range);
    } catch (IOException e) {
        System.out.println("生成题目时发生错误: " + e.getMessage());
    }
}

