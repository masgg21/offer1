package com.xatu.wangyi;
/**
 * @author Administrator
 * �������������
 */
public class TreeDepth {
	public int TreeDepth(TreeNode root) {
        if(root==null) {
        	return 0;
        }
        return 1+(TreeDepth(root.left)>TreeDepth(root.right)?TreeDepth(root.left):TreeDepth(root.right));
	}
}
