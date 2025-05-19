package binaryTree;

import java.util.*;

public class levelOrder {
    /*
        给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
        示例 1：
        输入：
        root = [3,9,20,null,null,15,7]
        输出：[[3],[9,20],[15,7]]
        示例 2：
        输入：
        root = [1]
        输出：[[1]]
        示例 3：
        输入：
        root = []
        输出：[]
        */
    public List<List<Integer>> solution(TreeNode root) {
        //用于储存每一行的数据
        List<List<Integer>> result = new ArrayList<>();
        // 如果根节点为空，直接返回空结果
        if (root == null) {
            return result;
        }
        // 使用队列辅助层序遍历，初始化队列并将根节点加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 当队列不为空时，继续处理每一层的节点
        while (!queue.isEmpty()){
            // 记录当前层的节点数量
            int size = queue.size();
            // 初始化当前层的节点值列表
            List<Integer> list = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队列头部取出一个节点
                TreeNode poll = queue.poll();
                // 将当前节点的值加入当前层的列表
                list.add(poll.val);
                // 如果当前节点有左子节点，将左子节点加入队列（下一层）
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                // 如果当前节点有右子节点，将右子节点加入队列（下一层）
                if (poll.left != null){
                    queue.offer(poll.left);
                }
            }
            // 将当前层的节点值列表加入最终结果列表
            result.add(list);
        }
        // 返回最终的层序遍历结果
        return result;
    }
}
