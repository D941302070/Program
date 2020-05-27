package LeetcodePrimaryAlgorithm.arr;

import java.util.HashSet;
import java.util.Set;

public class Demo05 {
    public int singleNumber(int[] nums) {
        /*Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            if (!set.add(nums[i]))
                set.remove(nums[i]);
        int res = 0;
        for (Integer i : set)
            res = i;
        return res;
         */
        //位运算，相同元素异或为0，异或满足交换律和结合律
        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }
}
