package HomeWork2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
//        从外部当如文件,判断对错个数
        //        找到文件的路径
        String exerciseFilePath = "D:\\idea\\basic-code\\Exercises.txt";
        String answerFilePath = "D:\\idea\\basic-code\\Answers.txt";

//        出错显示
        if (exerciseFilePath == null || answerFilePath == null) {
            System.out.println("Myapp.exe -e <exercisefile>.txt -a <answerfile>.txt");
            return;
        }

//        读取题目和答案
        try {
//            调用readFile函数,读取文件,并把他们放到list集合中,方便以后调用
            List<String> exercises = readFile(exerciseFilePath);
            List<String> answers = readFile(answerFilePath);

//            判断是否正确,并统计
            List<Integer> correct = new ArrayList<>();
            List<Integer> wrong = new ArrayList<>();
//            1.逐个获取exercises,和answers
//            2.利用分割函数split,将函数分开
//            3.然后调用isCorrect,判断是否相等
            for (int i = 0; i < exercises.size(); i++) {
//                获取运算数字前面的式子,去掉等号后面
                String exercise = exercises.get(i).split("=")[0];
//                获取答案
                String answer = answers.get(i);
//                判断
                if (isCorrectAnswer(exercise, answer)) {
                    correct.add(i + 1);
                } else {
                    wrong.add(i + 1);
                }
            }
//            将结果写入文件中
            writeGradeFile(correct, wrong);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean isCorrectAnswer(String exercise, String answer) {
        String[] exercises = new String[2];
        boolean flag = false;
        for (int i = 0; i < exercise.length(); i++) {
            if (exercise.charAt(i) == '+') {
                exercises = exercise.split("\\+");
                int num1 = isNum(exercises[0]);
                int num2 = isNum(exercises[1]);
                int answers = Integer.parseInt(answer);
                if (num1 + num2 == answers) flag = true;
                break;
            } else if (exercise.charAt(i) == '-') {
                exercises = exercise.split("-");
                int num1 = isNum(exercises[0]);
                int num2 = isNum(exercises[1]);
                int answers = Integer.parseInt(answer);
                if (num1 - num2 == answers) flag = true;
                break;
            } else if (exercise.charAt(i) == '*') {
                exercises = exercise.split("\\*");
                int num1 = isNum(exercises[0]);
                int num2 = isNum(exercises[1]);
                int answers = Integer.parseInt(answer);
                if (num1 * num2 == answers) flag = true;
                break;
            } else if (exercise.charAt(i) == '/') {
                exercises = exercise.split("/");
                int num1 = isNum(exercises[0]);
                int num2 = isNum(exercises[1]);
                int answers = Integer.parseInt(answer);
                if (num1 / num2 == answers) flag = true;
                break;
            }
        }
        return flag;
    }

    private static int isNum(String number) {
        int num = Integer.parseInt(number);

        return num;
    }

    //    读入文件的重写
    private static List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static void writeGradeFile(List<Integer> correct, List<Integer> wrong) throws IOException {
        try (PrintWriter writer = new PrintWriter("Grade.txt")) {
            writer.println("Correct: " + correct.size() + " (" + listToString(correct) + ")");
            writer.println("Wrong: " + wrong.size() + " (" + listToString(wrong) + ")");
        }
    }

    private static String listToString(List<Integer> list) {
        return String.join(", ", list.toString().replaceAll("[\\[\\]]", ""));
    }
}
