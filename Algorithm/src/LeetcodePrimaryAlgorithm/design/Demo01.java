package LeetcodePrimaryAlgorithm.design;

import java.util.Arrays;
import java.util.Random;

public class Demo01 {

}

class Solution {

    int[] arr;

    public Solution(int[] nums) {
        arr = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = arr.length;
        int[] sa = arr.clone();
        for (int i = 0; i < len; i++) {
            int temIndex = new Random().nextInt(len);
            int tem = sa[i];
            sa[i] = sa[temIndex];
            sa[temIndex] = tem;
        }
        return sa;
    }
}