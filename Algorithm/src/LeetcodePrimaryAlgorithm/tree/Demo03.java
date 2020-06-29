package LeetcodePrimaryAlgorithm.tree;

/*
对称二叉树
给定一个二叉树，检查它是否是镜像对称的。



例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3


但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 */
public class Demo03 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        return compare(root.left, root.right);
    }

    //递归比较两个节点是否相同
    public boolean compare(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if ((l == null || r == null) || (l.val != r.val)) return false;
        return l.val == r.val && compare(l.left, r.right) && compare(l.right, r.left);
    }
}
