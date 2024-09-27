package HomeWork2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test1 {
    //    final定义局部变量,将Exercises.txt和Answers.txt卸载最开头,则所有方法中都可以调用
//    将随机生成的函数也写在最开头
    private static final String EXERCISES_FILE = "Exercises.txt";
    private static final String ANSWERS_FILE = "Answers.txt";
    private static final Random random = new Random();

    public static void main(String[] args) {
//        控制生成题目的个数,以及题目数值的范围
//        并将生成的题目和答案写进文档

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
}
