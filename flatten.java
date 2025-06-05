package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class flatten {
    public  void solution(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root , list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.right = curr;
            prev.left = null;
        }

    }
    public void preorderTraversal(TreeNode node , List<TreeNode> list){
        if (node != null){
            list.add(node);
        }
        preorderTraversal(node.left , list);
        preorderTraversal(node.right , list);
    }
    /*前序遍历（Preorder Traversal）：首先，代码通过前序遍历（根节点 -> 左子树 -> 右子树）收集所有节点，
    并将它们按顺序存储在一个列表中。
     重构链表：然后，遍历这个列表，将每个节点的左指针设为 null，右指针指向列表中的下一个节点，
    从而将二叉树展开为一个链表。
    */
}
