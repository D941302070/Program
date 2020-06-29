package Leetcode;

import java.util.Arrays;

/*
1300. 转变数组后最接近目标值的数组和
给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

请注意，答案不一定是 arr 中的数字。



示例 1：

输入：arr = [4,9,3], target = 10
输出：3
解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
示例 2：

输入：arr = [2,3,5], target = 10
输出：5
示例 3：

输入：arr = [60864,25176,27249,21296,20204], target = 56803
输出：11361


提示：

1 <= arr.length <= 10^4
1 <= arr[i], target <= 10^5
 */
public class Demo1300 {
    /*
    1.排序
    2.数组求和求和target的差值
    3.从右边开始尝试，右边每个数字与value的值得差值之和要等于2的差值
     */
    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int count = 0;
        for (int i : arr)
            count += i;
        int len = arr.length;
        if (count <= target) return arr[len - 1];

        int value = 0;
        int x = count - target;//数组和target差值
        int tem = 0;//右边每个数字与value的值得差值之和
        for (int i = len - 1; i >= 0; i--) {
            int end = i == 0 ? Integer.MIN_VALUE : arr[i - 1];
            tem--;//每次value与数组值相等时，只有当前点右边会自减
            for (value = arr[i]; value > end; value--) {
                //每次增加的差值和相当于右边每个元素都自减1，差值和就是右边元素个数
                tem += len - i;
                //差值不到target
                if (tem < x) continue;
                    //差值相同后找到最接近的值
                else if (tem == x) return value;
                else if (value == arr[i])
                    return x - (tem - (len - i - 1)) > tem - x ? value : value + 1;
                else
                    return x - (tem - (len - i)) > tem - x ? value : value + 1;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int a[] = {1,2,23,24,34,36};
        findBestValue(a, 110);
    }
}

class Sol {
    public int findBestValue(int[] arr, int target) {
        int big = 0;
        int sum = 0;
        for (int i : arr) {
            sum += i;
            big = big > i ? big : i;
        }
        //从均值开始往上走
        if(sum <= target) return big;
        int ans = target / arr.length;
        sum = getSum(arr, ans);
        while(sum < target) {
            int tem = getSum(arr, ans + 1);
            //临界值
            if(tem >= target) return target - sum <= tem - target ? ans : ans + 1;
            sum = tem;
            ans++;
        }
        return 0;
    }

    public int getSum(int[] arr, int value) {
        int sum = 0;
        for (int i : arr) sum += i < value ? i : value;
        return sum;
    }
}