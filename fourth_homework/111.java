/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(null == root)
            return 0;
        if(null == root.left && null == root.right)
            return 1;
        if(null != root.left && null != root.right) {
            int left_deep = 1 + minDepth(root.left);
            int right_deep = 1 + minDepth(root.right);
            return  left_deep > right_deep? right_deep: left_deep;
        }
        if(null != root.left)
            return minDepth(root.left) + 1;
        if(null != root.right)
            return  minDepth(root.right) + 1;
        return  0;
    }
}