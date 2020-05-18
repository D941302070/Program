package study.exception;

import java.util.Scanner;

public class Demo10 {
    //1.使用数组保存已经注册过的用户名
    static String[] usernames = {"张三", "李四", "王五"};

    public static void main(String[] args) {
        //2. 使用scanner获取用户输入的注册的用户名
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要注册的用户名");
        String username = sc.next();
        checkUsername(username);
    }

    //3.定义一个方法，对用户输入的注册名进行判断

    public static void checkUsername(String username) {
        for (String name : usernames) {
            if (name.equals(username)) {
                try {
                    throw new RegisterException("该用户已经注册");
                } catch (RegisterException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        System.out.println("恭喜您注册成功");
    }
}
