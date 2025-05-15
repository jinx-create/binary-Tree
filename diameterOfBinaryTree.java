package binaryTree;

public class diameterOfBinaryTree {
    /*给你一棵二叉树的根节点，返回该树的 直径 。
    二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
    两节点之间路径的 长度 由它们之间边数表示。 
    示例 1：
    输入：
    root = [1,2,3,4,5]
    输出：
            3
    解释：
            3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
    示例 2：
    输入：
    root = [1,2]
    输出：
            1*/
    // 全局变量，用于记录当前找到的最大直径（最长路径的节点数）
    int temp = 0;
    // 主方法：计算二叉树的直径
    public int solution(TreeNode root){
        // 调用递归检查方法
        check(root);
        // 返回最终找到的最大直径
        return temp;
    }
    // 递归检查方法：计算每个节点的深度并更新最大直径
    public int check(TreeNode node){
        // 递归终止条件：空节点的深度为0
        if (node == null){
            return 0;
        }
        // 递归计算左子树的深度
        int leftLen = check(node.left);
        //递归计算右子树的深度
        int rightLen = check(node.right);
        // 更新全局最大直径（当前节点作为根时的路径长度 = 左深度 + 右深度）
        temp = Math.max(temp , leftLen + rightLen);
        // 返回当前节点的深度（左右子树中较大的深度 + 1）
        return  (rightLen + leftLen) + 1;
    }
}
