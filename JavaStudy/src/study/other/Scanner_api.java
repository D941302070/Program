package study.other;

/**
 * scanner类的部分用法
 * @author 淺い空
 */
import java.util.Scanner;

public class Scanner_api {
	public static void main(String[] args) {

		System.out.println("请输入姓名");
		Scanner sc = new Scanner(System.in);

		String name = sc.next();

		char xing = name.charAt(0);// a.charAt(s)获取a字符串的第s个字符

		System.out.println("姓名：" + name);
		System.out.println("姓：" + xing);
		// next以空格和回车为结束
		// nextline以回车为结束

		System.out.println("请输入身高");
		int shengao = sc.nextInt();


		System.out.println("身高：" + shengao);
		sc.close();// 关闭sc的空间
	}
}