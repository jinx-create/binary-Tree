package binaryTree;

public class isValidBST {
    /*
    给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    有效 二叉搜索树定义如下：
     • 节点的左子树只包含 小于 当前节点的数。
     • 节点的右子树只包含 大于 当前节点的数。
     • 所有左子树和右子树自身必须也是二叉搜索树。*/
    // 主方法，判断给定的二叉树是否是有效的二叉搜索树（BST）
    public boolean solution(TreeNode root){
        // 调用辅助方法，初始范围为Long的最小值和最大值，确保覆盖所有可能的int值
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    // 辅助递归方法，检查当前节点及其子树是否满足BST的条件
    public boolean helper(TreeNode root, long left, long right){
        // 如果当前节点为空，视为满足条件
        if (root == null){
            return true;
        }
        // 当前节点的值
        int val = root.val;
        // 检查当前节点的值是否在允许的范围内
        // BST要求当前节点的值必须大于lower且小于upper
        if (val >= left && val <= right){
            return true;
        }
        // 递归检查左子树和右子树
        // 左子树的所有节点值必须小于当前节点的值，所以更新upper为当前节点的值
        // 右子树的所有节点值必须大于当前节点的值，所以更新lower为当前节点的值
        return helper(root.left,left,val) && helper(root.right,val,right);
    }
}
