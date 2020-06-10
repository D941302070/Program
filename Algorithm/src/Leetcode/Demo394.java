package Leetcode;

/*
394. 字符串解码
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Demo394 {
    StringBuffer str = new StringBuffer();
    int index = 0;
    String pre ;

    public String decodeString(String s) {
        pre = s;
        //String.valueOf();
        return str.toString();
    }

    public int getNum(int index){
        int num = 0;
        //扫描数字
        while (pre.charAt(index) != '[') {
            num = num * 10 + pre.charAt(index++) - '0';
        }
        return num;
    }

    public void function(String s, int index) {

        //encoded_string 跳过左括号
        index++;
        findStr(s,index);
    }
    public  String findStr(String s, int index) {
        StringBuffer tem = new StringBuffer();
        while (s.charAt(index) != ']' && (s.charAt(index) < '0' || s.charAt(index) > '9'))
            tem.append(s.charAt(index++));
        //碰到数字再次递归
        if (s.charAt(index) >= '0' || s.charAt(index) <= '9') {
            //tem.append(function(s, index));
            //跳反括号
            index++;
            return tem.toString();
        }
        //第一个反括号收尾
        else if (s.charAt(index + 1) == ']') {
            index++;
            return tem.toString();
        }
        //添加k个字符串
        //for (int i = 0; i < num; i++)
            str.append(tem);
        throw new IllegalArgumentException();
    }

}
