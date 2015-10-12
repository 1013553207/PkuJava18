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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else if(root.left==null){
            if(root.right==null) return 1;
            else return maxDepth(root.right) + 1;
        }
        else {
            if(root.right==null) return maxDepth(root.left) + 1;
            else {
                int a=maxDepth(root.left);
                int b=maxDepth(root.right);
                if(a>=b) return a+1;
                else return b+1;
            }
        }
    }
}