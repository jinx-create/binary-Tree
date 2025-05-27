package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView {
    public List<Integer> solution(TreeNode root){
        //创建一个空列表result用于存储结果
        //如果根节点为null（空树），直接返回空列表
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        //创建一个队列（使用LinkedList实现）
        //将根节点加入队列，开始BFS遍历
        Queue<TreeNode> queue = new LinkedList<>();
        //外层while循环：只要队列不为空就继续处理
        //levelSize记录当前层的节点数，这个值在for循环开始前确定，确保我们只处理当前层的节点
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1){
                    result.add(poll.val);
                }
                //queue.poll()取出队列头部的节点（当前节点）
                //检查是否是当前层的最后一个节点（i == levelSize - 1）
                //如果是最后一个节点，将其值加入结果列表（这就是右视图的关键
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                //将当前节点的左子节点（如果存在）加入队列
                //将当前节点的右子节点（如果存在）加入队列
                //这些子节点将在下一轮循环中处理（下一层）
            }
        }
        return result;
    }
}
