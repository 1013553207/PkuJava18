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
    public List<Integer> inorderTraversal(TreeNode root) {
        List m_list = new ArrayList<Integer>();
        if(root == null)
            return  m_list;
        else{
            if(root.left != null)
                m_list.addAll(inorderTraversal(root.left));
            m_list.add(root.val);
            if(root.right != null)
                m_list.addAll(inorderTraversal(root.right));
        }
        return  m_list;
    }
    
}