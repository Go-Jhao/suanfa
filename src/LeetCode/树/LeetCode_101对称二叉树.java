package LeetCode.树;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_101对称二叉树 {
//    public boolean isSymmetric(TreeNode root) {
//        if (root==null){
//            return true;
//        }
//        return deepCheck(root.left,root.right);
//    }
//    boolean deepCheck(TreeNode left,TreeNode right){
//        //递归的终点是两个节点否为空
//        //或者两个节点有一个为空
//        //或者两个节点的值不同
//        if (left == null && right == null){
//            return true;
//        }
//        if (left ==null || right == null){
//            return false;
//        }
//        if (left.val!=right.val){
//            return false;
//        }
//        //在递归的比较 左节点左的孩子 和 右节点的右孩子
//        //以及比较  左节点的右孩子 和右节点的做孩子
//        return deepCheck(left.left,right.right)&&deepCheck(left.right,right.left);
//    }



    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode u = root.left;
        TreeNode v = root.right;
        if(root==null || (u ==null&&v==null)){
            return true;
        }
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null&&v == null){
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);


            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
