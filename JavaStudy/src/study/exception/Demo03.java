package study.exception;
/*
throw关键字
作用：
    可以使用throw在指定的方法中抛出指定的异常
使用格式：
    throw new xxxException("异常抛出的原因");
注意事项：
    1.throw关键字必须写在方法的内部
    2.throw关键字后new的对象必须是Exception或Exception子类对象
    3.throw关键字抛出指定异常对象，必须处理异常对象
        throw关键字后创建的是RuntimeException或者是RuntimeException的子类对象，可以不处理，默认交给JVM处理（打印异常，中断程序）
        throw关键字后创建的是编译异常（写代码的时候报错），就必须处理这个异常，要吗throws，要吗try...catch
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] arr = null;
        int e = getElement(arr, 3);
    }
    /*
    定义一个方法，获取数组指定索引处的元素
    参数：
        int[] arr
        int index

    NullPointerException是运行期异常，默认交给jvm处理
    IndexOutOfBoundsException是运行期异常，默认交给jvm处理
     */
    public static int getElement(int[] arr, int index) {
        /*
        可以对传递过来的参数数组，进行合法性校验
        如果数组arr的值是null
        那么我们抛出空指针异常，告知方法的调用者“传递的数组值为null”
         */
        if(arr == null){
            throw new NullPointerException("传递的数组值为空");
        }
        /*
        可以对传递过来的参数index，进行合法性校验
        如果index的范围不在数组的索引范围内
        那么我们抛出数组索引越界异常，告知方法的调用者“传递索引超出了数组的使用范围”
         */
        if (index<0||index>arr.length-1){
            throw new IndexOutOfBoundsException("传递索引超出了数组的使用范围");
        }
        int ele = arr[index];
        return ele;
    }
}
