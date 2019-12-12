package XueXiJiLu.Api.ArrayList_api;

import java.util.ArrayList;

/**
 * 添加4个学生对象，并添加到集合，遍历
 */
public class ArrayList05Student {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student one = new Student("段星雨", 18);
        Student two = new Student("王豆豆", 19);
        list.add(one);//常规赋值
        list.add(two);
        list.add(new Student("李华", 20));//匿名方法
        list.add(new Student("小明", 6));
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println
                    ("姓名:" + stu.getName() + "  年龄:" + stu.getAge());
        }
    }
}

