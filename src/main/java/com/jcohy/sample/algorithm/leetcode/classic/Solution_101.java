package com.jcohy.sample.algorithm.leetcode.classic;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 2023.0.1 2024/3/24:22:25
 * @since 2023.0.1
 */
public class Solution_101 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 通常可以通过递归的方式来判断。具体做法是比较树的左右两侧是否对称，也就是比较左子树的左节点和右子树的右节点、左子树的右节点和右子树的左节点是否相等。
     *
     * 在这段代码中，首先定义了树节点 TreeNode 类，然后通过 isSymmetric 方法调用 isSymmetricHelper 方法进行递归判断。
     * isSymmetricHelper 方法用于比较左右两侧是否对称，如果左右子树都为空，返回 true；如果左右子树其中一个为空或者值不相等，返回 false；
     * 否则递归比较左子树的左节点和右子树的右节点、左子树的右节点和右子树的左节点。如果递归过程中都能保持对称，最终返回 true，否则返回 false。
     *
     * 它使用递归的方式来检查二叉树是否轴对称，时间复杂度为 O(n)，其中 n 是二叉树中节点的数量。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
