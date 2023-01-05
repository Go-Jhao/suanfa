package LeetCode.树;

public class LeetCode_104二叉树的最大深度 {
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }else{
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}
