package LeetcodePrimaryAlgorithm.arr;

public class Demo03 {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        int tempNum = nums[0], index = 0, pre = index;
        while (count < nums.length) {
            if (count > 0 && index == pre) {
                index++;
                tempNum = nums[index];
                pre = index;
            }
            index = (index + k) % nums.length;
            int tem = nums[index];
            nums[index] = tempNum;
            tempNum = tem;
            count++;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,5,6};
        rotate(a, 1200564);
    }
}
