package lq;/*
问题描述
　　小明要组织一台晚会，总共准备了 n 个节目。然后晚会的时间有限，他只能最终选择其中的 m 个节目。
　　这 n 个节目是按照小明设想的顺序给定的，顺序不能改变。
　　小明发现，观众对于晚上的喜欢程度与前几个节目的好看程度有非常大的关系，他希望选出的第一个节目尽可能好看，在此前提下希望第二个节目尽可能好看，依次类推。
　　小明给每个节目定义了一个好看值，请你帮助小明选择出 m 个节目，满足他的要求。
输入格式
　　输入的第一行包含两个整数 n, m ，表示节目的数量和要选择的数量。
　　第二行包含 n 个整数，依次为每个节目的好看值。
输出格式
　　输出一行包含 m 个整数，为选出的节目的好看值。
样例输入
5 3
3 1 2 5 4
样例输出
3 5 4
样例说明
　　选择了第1, 4, 5个节目。
评测用例规模与约定
　　对于 30% 的评测用例，1 <= n <= 20；
　　对于 60% 的评测用例，1 <= n <= 100；
　　对于所有评测用例，1 <= n <= 100000，0 <= 节目的好看值 <= 100000。
 */
/*
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list.add(0);//0号元素,无意义
        int n = sc.nextInt();//总
        int m = sc.nextInt();//选
        for (int i = 0; i < n; i++)
            list.add(sc.nextInt());
        find(1, m, n);
    }

    public static void find(int startNum, int chooseNum, int n) {
        int max = list.get(startNum);
        int maxIndex = startNum;
        for (int i = startNum + 1; i <= n - chooseNum + 1; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                maxIndex = i;
            }
        }
        System.out.print(max + " ");
        if (chooseNum == 1) return;
        find(maxIndex + 1, chooseNum - 1, n);
    }
}
*/
/*
问题描述
　　小明想知道，满足以下条件的正整数序列的数量：
　　1. 第一项为 n；
　　2. 第二项不超过 n；
　　3. 从第三项开始，每一项小于前两项的差的绝对值。
　　请计算，对于给定的 n，有多少种满足条件的序列。
输入格式
　　输入一行包含一个整数 n。
输出格式
　　输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数。
样例输入
4
样例输出
7
样例说明
　　以下是满足条件的序列：
　　4 1
　　4 1 1
　　4 1 2
　　4 2
　　4 2 1
　　4 3
　　4 4
评测用例规模与约定
　　对于 20% 的评测用例，1 <= n <= 5；
　　对于 50% 的评测用例，1 <= n <= 10；
　　对于 80% 的评测用例，1 <= n <= 100；
　　对于所有评测用例，1 <= n <= 1000。
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);//索引0，无意义
        list.add(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
            plus(3, list);
            list.remove(list.size() - 1);
        }
        System.out.println(count);
    }

    public static void plus(int k, ArrayList<Integer> list) {
        //k为项数
        count = (count + 1) % 10000;
        if (Math.abs(list.get(k - 1) - list.get(k - 2)) <= 1)
            return;
        for (int i = 1; i < Math.abs(list.get(k - 1) - list.get(k - 2)); i++) {
            list.add(i);
            plus(k + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

/*
问题描述
　　小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为 1。
　　小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。
　　这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，则它将向自己的上、下、左、右四小块空地扩展，这四小块空地都将变为有草的小块。
　　请告诉小明，k 个月后空地上哪些地方有草。
输入格式
　　输入的第一行包含两个整数 n, m。
　　接下来 n 行，每行包含 m 个字母，表示初始的空地状态，字母之间没有空格。如果为小数点，表示为空地，如果字母为 g，表示种了草。
　　接下来包含一个整数 k。
输出格式
　　输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。如果为小数点，表示为空地，如果字母为 g，表示长了草。
样例输入
4 5
.g...
.....
..g..
.....
2
样例输出
gggg.
gggg.
ggggg
.ggg.
评测用例规模与约定
　　对于 30% 的评测用例，2 <= n, m <= 20。
　　对于 70% 的评测用例，2 <= n, m <= 100。
　　对于所有评测用例，2 <= n, m <= 1000，1 <= k <= 1000。
 */

/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] lawn = new char[n + 2][m + 2];
        for (int i = 1; i <= n; i++)
            lawn[i] = (" " + sc.next() + " ").toCharArray();
        int k = sc.nextInt();
        for (int i = 1; i <= k; i++) {
            growth(lawn, Integer.toString(i).charAt(0));
        }
        for (int i = 1; i < lawn.length - 1; i++) {
            for (int j = 1; j < lawn[0].length - 1; j++) {
                if (lawn[i][j] != '.')
                    System.out.print('g');
                else System.out.print('.');
            }
            System.out.println();
        }
    }

    public static void growth(char[][] lawn, char k) {
        for (int i = 1; i < lawn.length - 1; i++) {
            for (int j = 1; j < lawn[0].length - 1; j++) {
                if (lawn[i][j] != '.' && lawn[i][j] != k) {
                    if (lawn[i - 1][j] == '.') lawn[i - 1][j] = k;
                    if (lawn[i + 1][j] == '.') lawn[i + 1][j] = k;
                    if (lawn[i][j - 1] == '.') lawn[i][j - 1] = k;
                    if (lawn[i][j + 1] == '.') lawn[i][j + 1] = k;
                }
            }
        }
    }
}*/

/*
问题描述
　　在数列 a[1], a[2], ..., a[n] 中，如果对于下标 i, j, k 满足 0<i<j<k<n+1 且 a[i]<a[j]<a[k]，则称 a[i], a[j], a[k] 为一组递增三元组，a[j]为递增三元组的中心。
　　给定一个数列，请问数列中有多少个元素可能是递增三元组的中心。
输入格式
　　输入的第一行包含一个整数 n。
　　第二行包含 n 个整数 a[1], a[2], ..., a[n]，相邻的整数间用空格分隔，表示给定的数列。
输出格式
　　输出一行包含一个整数，表示答案。
样例输入
5
1 2 5 3 5
样例输出
2
样例说明
　　a[2] 和 a[4] 可能是三元组的中心。
评测用例规模与约定
　　对于 50% 的评测用例，2 <= n <= 100，0 <= 数列中的数 <= 1000。
　　对于所有评测用例，2 <= n <= 1000，0 <= 数列中的数 <= 10000。
 */

/*import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int count = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        for (int i = 0; i < len; i++)
            list.add(sc.nextInt());
        if (len < 3) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i < len - 1; i++) {
            find(i);
        }
        System.out.println(count);
    }

    public static void find(int index) {
        int flag = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (list.get(i) < list.get(index)) {
                flag++;
                break;
            }
        }
        if (flag == 0) return;
        else
            for (int i = index + 1; i < list.size(); i++) {
                if (list.get(i) > list.get(index)) {
                    flag++;
                    break;
                }
            }
        if (flag == 2) count++;
        else return;
    }
}
*/



/*
问题描述
　　小明对类似于 hello 这种单词非常感兴趣，这种单词可以正好分为四段，第一段由一个或多个辅音字母组成，第二段由一个或多个元音字母组成，第三段由一个或多个辅音字母组成，第四段由一个或多个元音字母组成。
　　给定一个单词，请判断这个单词是否也是这种单词，如果是请输出yes，否则请输出no。
　　元音字母包括 a, e, i, o, u，共五个，其他均为辅音字母。
输入格式
　　输入一行，包含一个单词，单词中只包含小写英文字母。
输出格式
　　输出答案，或者为yes，或者为no。
样例输入
lanqiao
样例输出
yes
样例输入
world
样例输出
no
评测用例规模与约定
　　对于所有评测用例，单词中的字母个数不超过100。
 */

/*import java.util.*;

public class Main {
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        String str = new Scanner(System.in).nextLine();
        int one = fuyin(str);
        if (one == -1||one==0) {
            System.out.println("no");
            return;
        }
        int two = yuanyin(str.substring(one));
        if (two == -1) {
            System.out.println("no");
            return;
        }
        int three = fuyin(str.substring(one+two));
        if (three == -1){
            System.out.println("no");
            return;
        }
        int four = yuanyin(str.substring(one+two+three));
        if (four == -1) System.out.println("yes");
        else System.out.println("no");
    }
    public static int yuanyin(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i)))
                return i;
        }
        return -1;
    }
    public static int fuyin(String str){
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i)))
                return i;
        }
        return -1;
    }
}*/



/*
问题描述
　　一个正整数如果任何一个数位不大于右边相邻的数位，则称为一个数位递增的数，例如1135是一个数位递增的数，而1024不是一个数位递增的数。
　　给定正整数 n，请问在整数 1 至 n 中有多少个数位递增的数？
输入格式
　　输入的第一行包含一个整数 n。
输出格式
　　输出一行包含一个整数，表示答案。
样例输入
30
样例输出
26
评测用例规模与约定
　　对于 40% 的评测用例，1 <= n <= 1000。
　　对于 80% 的评测用例，1 <= n <= 100000。
　　对于所有评测用例，1 <= n <= 1000000。
 */
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int count = 0;
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n; i++) {
            int num = i;
            int right = 9;
            while (num != 0) {
                int pop = num % 10;
                if (pop > right) {
                    count--;
                    break;
                }
                right = pop;
                num /= 10;
            }
            count++;
        }
        System.out.println(count);
    }
}*/