package LeetcodePrimaryAlgorithm.str;

/*
外观数列
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。
 */
public class Demo08 {
    public String countAndSay(int n) {
        StringBuffer sb = new StringBuffer("1");
        if (n == 1) return sb.toString();
        //算n-1个数
        for (int i = 1; i < n; i++) {
            StringBuffer tem = new StringBuffer();
            //开始扫描上一次的字符串
            char[] arr = sb.toString().toCharArray();
            int len = arr.length;
            int index = 0, end = index + 1;
            while (index < len) {
                //判断相同字符
                while (end < len && arr[index] == arr[end]) end++;
                tem.append(end - index);
                tem.append(arr[index]);
                //更新下一次开始点
                index = end;
            }
            sb = tem;
        }
        return sb.toString();
    }
}
