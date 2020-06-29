package LeetcodePrimaryAlgorithm.tree;

/*
将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class Demo05 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) return null;
        TreeNode root = new TreeNode(0);
        fun(root, nums, 0, nums.length - 1);
        return root;
    }

    public void fun(TreeNode root, int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        root.val = nums[mid];
        if (start == end) return;
        if (start != mid) {
            root.left = new TreeNode(0);
            fun(root.left, nums, start, mid - 1);
        }
        root.right = new TreeNode(0);
        fun(root.right, nums, mid + 1, end);
    }
}
