package LeetcodePrimaryAlgorithm.arr;

public class Demo08 {
    public void moveZeroes(int[] nums) {
        int before = 0, now = 0;

        //移动位置
        for (; now < nums.length; now++)
            if (nums[now] != 0)
                nums[before++] = nums[now];
        //后边数组变0
        for (; before < nums.length; before++)
            nums[before] = 0;
    }
}
