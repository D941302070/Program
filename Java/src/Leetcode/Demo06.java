package Leetcode;

/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo06 {

    private static String convert(String s, int numRows) {
        if (s.length() == 0) return s;
        StringBuilder newString = new StringBuilder();
        int num = s.length() / (2 * numRows - 2);//完整一组的数量
        int add;
        for (int i = 1; i <= numRows; i++) {//读取每一行
            for (int j = 1; j <= num + 1; j++) {//竖的一列，每行都一样
                add = (2 * numRows - 2) * (j - 1) + i;
                if (add > s.length())
                    break;
                newString.append(s.charAt(add - 1));//先竖
                if (i != 1 && i != numRows) {//斜的一组，除了第一和最后行
                    add = (2 * numRows - 2) * j - i + 2;
                    if (add > s.length())
                        break;
                    newString.append(s.charAt(add - 1));//再斜
                }
            }
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int i = 3;
        System.out.println(convert(s, i));
    }
}
