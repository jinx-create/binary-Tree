package binaryTree;

public class maxDepth {
    public static int solution(TreeNode root){
        if (root == null){
            return 0;
        }
        int rightLen = solution(root.right);
        int leftLen = solution(root.left);
        int temp = Math.max(rightLen,leftLen);
        return temp;
    }
}
