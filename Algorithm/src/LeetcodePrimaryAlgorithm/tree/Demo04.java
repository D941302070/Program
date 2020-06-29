package LeetcodePrimaryAlgorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class Demo04 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                //poll找头并删除
                TreeNode tem = queue.poll();
                temList.add(tem.val);
                if (tem.left != null) queue.add(tem.left);
                if (tem.right != null) queue.add(tem.right);
            }
            list.add(temList);
        }
        return list;
    }
}