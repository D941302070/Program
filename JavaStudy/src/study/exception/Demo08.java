package study.exception;

import java.util.List;

public class Demo08 {
    public static void main(String[] args) {
        /*
        多个异常的处理
            1.多个异常分别处理
            2.多个异常一次捕获，多次处理
            3.多个异常一次捕获一次处理
         */

        //1.多个异常分别处理

        try {
            int[] arr = {1,2,3};
            System.out.println(arr[3]);//数组越界异常
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        try {
            List<Integer> list = List.of(1, 2, 3);
            System.out.println(list.get(3));
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println("后续代码");

        //2.多个异常一次捕获，多次处理

        try {
            int[] arr = {1,2,3};
            System.out.println(arr[3]);//数组越界异常
            List<Integer> list = List.of(1, 2, 3);
            System.out.println(list.get(3));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }

        /*
        一个try多个catch注意事项：
            catch里边定义的异常变量，如果有子父类关系，那么子类的异常变量必须写在上边，否则就会报错
            ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
         */

        //3.多个异常一次捕获一次处理
        try {
            int[] arr = {1,2,3};
            System.out.println(arr[3]);//数组越界异常
            List<Integer> list = List.of(1, 2, 3);
            System.out.println(list.get(3));
        }catch (Exception e){
            System.out.println(e);
        }

        //运行时的异常可以不处理
        //默认会给虚拟机处理，什么时候不抛出运行时异常，再继续程序
    }
}
