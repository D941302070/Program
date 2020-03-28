package study.ArrayList;

/**
 * 定义一个数组用来储存3个person对象
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //创建一个长度为三的数组用来储存3个person对象
        Person[] array = new Person[3];

        Person one = new Person("段星雨", 18);
        Person two = new Person("李华", 15);
        Person three = new Person("小明", 6);

        //将one中的地址赋值给array的第0号元素
        array[0] = one;
        array[1] = two;
        array[2] = three;

        System.out.println(array[0].getName());
    }
}