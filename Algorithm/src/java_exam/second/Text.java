package java_exam.second;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) throws Exception {
        File f = new File("src\\java_exam\\second\\out.txt");
        //文件不存在
        if (!f.exists()) {
            //PrintWriter 若文件不存在自动创建新文件
            PrintWriter output = new PrintWriter(f);
            Random r = new Random();
            for (int i = 0; i < 100; i++) {
                //sb储存表达式
                StringBuffer sb = new StringBuffer();
                //r.nextDouble()是小数位，r.nextInt()是整数位
                //生成x
                sb.append(r.nextDouble()+r.nextInt());
                int operator = r.nextInt(4) + 1;
                //随机符号
                if (operator == 1) sb.append('+');
                if (operator == 2) sb.append('-');
                if (operator == 3) sb.append('*');
                if (operator == 4) sb.append('/');
                //生成y
                sb.append(r.nextDouble()+r.nextInt());
                //写入表达式
                output.print(sb.toString());
                ArithmeticExpression ae = new ArithmeticExpression(sb.toString());
                //写入结果
                output.println(" = "+ae.getResult());
            }
            output.close();
        }else{
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
