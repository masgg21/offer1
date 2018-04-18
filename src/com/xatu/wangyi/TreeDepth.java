package com.xatu.wangyi;
/**
 * @author Administrator
 * 求解二叉树的深度
 */
public class TreeDepth {
	public int TreeDepth(TreeNode root) {
        if(root==null) {
        	return 0;
        }
        return 1+(TreeDepth(root.left)>TreeDepth(root.right)?TreeDepth(root.left):TreeDepth(root.right));
	}
}
