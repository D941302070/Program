/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode;

public class Demo04 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] arr = new int[len1 + len2];
        int i = 0, j = 0, arrIndex = 0;
        for (; arrIndex < len1 + len2; arrIndex++) {
            if (i == len1 || len1 == 0) {
                System.arraycopy(nums2, j, arr, arrIndex, len2 - j);
                break;
            } else if (j == len2 || len2 == 0) {
                System.arraycopy(nums1, i, arr, arrIndex, len1 - i);
                break;
            }
            arr[arrIndex] = nums1[i] >= nums2[j] ? nums2[j++] : nums1[i++];
        }
        return (len1 + len2) % 2 == 0 ?
                ((double) arr[(len1 + len2) / 2] + arr[(len1 + len2) / 2 - 1]) / 2 :
                arr[(len1 + len2) / 2];
    }

}
