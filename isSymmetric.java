package binaryTree;

public class isSymmetric {
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.right , root.left);
    }

    public boolean check(TreeNode right, TreeNode left) {
        if (right == null || left == null) {
            return false;
        }
        if (right == null && left == null) {
            return true;
        }
        return (right.val == left.val) && check(right, left) && check(left, right);
    }
}
