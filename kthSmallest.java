package binaryTree;

import javax.management.StandardEmitterMBean;
import java.util.Stack;

public class kthSmallest {
    /*
    给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第k小的元素（从 1 开始计数）。
    示例 1：
    输入：root = [3,1,4,null,2], k = 1
    输出：1
    示例 2：
    输入：root = [5,3,6,2,4,null,null,1], k = 3
    输出：3
    */
    /*1. 栈的基本操作 栈的核心操作包括：
      • Push：将元素压入栈中。
      • Pop：移除并返回栈顶的元素。
      • Peek：返回栈顶的元素但不移除。
      • isEmpty：检查栈是否为空。
      • size：返回栈中元素的数量。*/
    public int solution(TreeNode root , int k){
        //1. 初始化
        //stack：用于模拟递归中序遍历的系统栈，存储待访问的节点。
        //current：当前遍历到的节点，初始指向根节点root。
        //count：计数器，记录已经访问过的节点数量。
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;
        //2. 外层循环：控制遍历的进行
        //条件：current != null或stack非空。
        //如果current != null，说明还有左子树待遍历。
        //如果stack非空，说明还有节点待处理（比如左子树遍历完毕，需要回溯父节点）。
        //作用：确保所有节点都被访问。
        while (current != null || stack.isEmpty()){
            //3. 内层循环：遍历左子树
            //作用：将当前节点及其所有左子节点依次入栈，直到current为null（即到达最左节点）。
            //模拟递归：相当于递归中序遍历的“一直向左走到底”。
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            //4. 访问节点（中序位置)
            //stack.pop()：弹出栈顶节点（当前最左节点），表示访问该节点。
            //count++：访问节点后，计数器count加1。
            //判断count == k：
            //如果count等于k，说明当前节点是第k小的，直接返回其值current.val。
            //否则继续遍历。
            current = stack.pop();
            count++;
            if (count == k){
                return current.val;
            }
            //5. 转向右子树
            //作用：访问当前节点的右子树（如果存在），继续中序遍历。
            //模拟递归：相当于递归中序遍历的“处理右子树”。
            current = current.right;
        }
        //6. 返回默认值
        //作用：如果k超出树的范围（题目保证k有效，此情况通常不会发生），返回-1。
        return -1;
    }
}
