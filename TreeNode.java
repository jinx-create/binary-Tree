package binaryTree;

public class TreeNode {
    //定义一个二叉树
    //存储节点的值。
    int val;
    //指向左子节点
    TreeNode left;
    //指向右子节点
    TreeNode right;
    //空节点
    TreeNode() {
    }
    //仅初始化val，左右子节点为 null。
    TreeNode(int val) {
        this.val = val;
    }
    //初始化 val、left 和 right。
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
