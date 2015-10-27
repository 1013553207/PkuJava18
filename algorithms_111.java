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
        int a = 0, b = 0;
        if(root == null) return 0;
        else if(root.left != null && root.right != null) {
            a = minDepth(root.left);
            b = minDepth(root.right);
            return (a < b) ? (a + 1) : (b + 1);
        }
        else if(root.left != null) return minDepth(root.left) + 1;
        else if(root.right != null) return minDepth(root.right) + 1;
        else return 1;
    }
}