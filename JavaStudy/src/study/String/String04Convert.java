package study.String;

/**
 * 字符串转换
 * ============
 * public char[] toCharArray();将字符串拆分为字符数组
 * =============
 * public byte[] getBytes();获取当前字符串的底层数组
 * =============
 * public String replace(CharSequence oldString ,CharSequence newString);
 * 将所有出现的老字符串替换为新字符串，返回替换后的新字符串
 */
public class String04Convert {

    public static void main(String[] args) {
        char[] chars = "hello".toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars.length);
        System.out.println("============");

        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("============");

        String str1 = "How do you do ?";
        String str2 = str1.replace("o", "*");
        System.out.println(str1);
        System.out.println(str2);
    }

}
