package Leetcode;

/*
1103. 分糖果 II
排排坐，分糖果。

我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。

给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。

然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。

重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。

返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 */
public class Demo1103 {
    public static int[] distributeCandies(int candies, int num_people) {
        /*
        第k轮第i个人发(k-1)*num_people+i
        第k轮一共发(k-1)*num_people*num_people+(1+num_people)*num_people/2
         */
        int k = 1;//发的轮数
        int tem = 0;
        while (tem <= candies)
            tem += (k++ - 1) * num_people * num_people + (1 + num_people) * num_people / 2;
        //剩下的不足一轮的糖果
        candies -= tem - (--k - 1) * num_people * num_people - (1 + num_people) * num_people / 2;
        int[] array = new int[num_people];
        for (int i = 0; i < array.length; i++) {
            if (k > 1) array[i] = (i + 1) * (k - 1) + (k - 2) * (k - 1) / 2 * num_people;
            if (candies == 0) continue;
            tem = (k - 1) * num_people + i + 1;
            if (tem < candies) {
                array[i] += tem;
                candies -= tem;
            } else {
                array[i] += candies;
                candies = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        distributeCandies(10, 3);
    }
}
