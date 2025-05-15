package binaryTree;


import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    public static void main(String[] args) {

    }
    //给定一个二叉树的根节点 root ，返回 它的中序遍历

    //定义一个二叉树
    class TreeNode {
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

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    private static void inorder(TreeNode node , List<Integer> result) {
        if (node == null){
            return;
        }
        inorder(node.left,result);
        result.add(node.val);
        inorder(node.right,result);
    }
}
