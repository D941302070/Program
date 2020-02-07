package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Demo15 {
    /*
    外层for用来控制左边元素，
    while最右边元素，
    再找到中间的一个数，然后二分查找到结果
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;
        if (nums.length == 3)
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[0]);
                tmp.add(nums[1]);
                tmp.add(nums[2]);
                list.add(tmp);
                return list;
            }
        Arrays.sort(nums);//数组排序
        if (nums[0] >= 0 || nums[nums.length - 1] <= 0)
            if (nums[0] + nums[1] + nums[2] == 0 || nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(0);
                tmp.add(0);
                tmp.add(0);
                list.add(tmp);
                return list;
            } else return list;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] >= 0) break;
            int left = i;
            int right = nums.length - 1;
            int l = left + 1, r = right - 1;
            while (right - left > 1) {
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (mid==left||mid==right) break;
                    int temp = nums[mid] + nums[left] + nums[right];
                    if (temp == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[left]);
                        tmp.add(nums[mid]);
                        tmp.add(nums[right]);
                        list.add(tmp);
                        break;
                    }
                    if (temp < 0) l = mid + 1;
                    if (temp > 0) r = mid - 1;
                }
                right--;
                l = left;
                r = right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = {1,2,-2,-1};
        threeSum(a);
    }
}
