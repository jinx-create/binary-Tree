package binaryTree;

public class sortedArrayToBST {
    //给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡二叉搜索树。
    public TreeNode solution(int[] num){

        return helper(num,0,1);
    }
    public TreeNode helper(int[] num,int left,int right){
        //递归的终止条件当左边界超过右边界时，返回null
        if (left > right){
            return null;
        }
        //计算当前数组的中间索引，避免整数溢出
        int mid = left + (right - left) / 2;
        // 以中间元素作为根节点创建树节点
        TreeNode root = new TreeNode(num[mid]);
        // 递归构建左子树，范围为左边界到mid-1
        root.left = helper(num , left , mid - 1);
        // 递归构建右子树，范围为mid+1到右边界
        root.right = helper(num , mid + 1 , right);
        // 返回当前子树根节点
        return root;
    }
}
