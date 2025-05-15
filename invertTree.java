package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class invertTree {
    public TreeNode solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return null;
        }
        //交换左右子树的位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归处理左右子树
        solution(root.left);
        solution(root.right);
        return root;
    }
}
