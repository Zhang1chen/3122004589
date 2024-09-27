package HomeWork2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

private static void makeQuestions(int numberQuestions, int range) throws IOException {
//        创建HashSet集合,主要用来去重
    Set<String> questions=new HashSet<>();
//        创建写入文档对象
    FileWriter exercisesWriters=new FileWriter(EXERCISES_FILE);
    FileWriter answersWriters=new FileWriter(ANSWERS_FILE);
    String question;
    String answer;
    while (questions.size()<numberQuestions){
//            生成一个0-3之间的随机数,用于选择运算符
//            0:+
//            1:-
//            2:*
//            3:/
        int operation=random.nextInt(4);
//            生成两个0-range之间的随机数，用来参与运算
        int number1=random.nextInt(range);
        int number2=random.nextInt(range);
        switch (operation){
            case 0:{
                question=number1+"+"+number2+"= ?" ;
//                    计算算数之后的值
                answer=String.valueOf(number1+number2);
//                    判断是否重复,这就用到了HashSet集的特点,无序,不重复,无索引
                if(!questions.equals(question)){
                    questions.add(question);
                    exercisesWriters.write(question+"\n");
                    answersWriters.write(answer+"\n");
                }
                break;
            }
            case 1: {
//                    结果不能出现负数,所以先判断谁大谁小,将大的赋给number1
                if(number2>number1){
                    int temp=number1;
                    number1=number2;
                    number2=temp;
                }
                question=number1+"-"+number2+"= ?" ;
                answer=String.valueOf(number1-number2);
                if(!questions.equals(question)){
                    questions.add(question);
                    exercisesWriters.write(question+"\n");
                    answersWriters.write(answer+"\n");
                }
                break;
            }
            case 2: {
                question=number1+"*"+number2+"= ?" ;
                answer=String.valueOf(number1*number2);
                if(!questions.equals(question)){
                    questions.add(question);
                    exercisesWriters.write(question+"\n");
                    answersWriters.write(answer+"\n");
                }
                break;
            }
            case 3: {
                if(number2==0||number2==10){
                    number2=random.nextInt(range)+1;
                }
                question=number1+"/"+number2+"= ?" ;
                answer=String.valueOf(number1/number2);
                if(!questions.equals(question)){
                    questions.add(question);
                    exercisesWriters.write(question+"\n");
                    answersWriters.write(answer+"\n");
                }
                break;
            }
        }
    }
    exercisesWriters.close();
    answersWriters.close();

}