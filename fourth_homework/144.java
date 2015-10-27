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
     public List<Integer> preorderTraversal(TreeNode root) {
        List m_list = new ArrayList<Integer>();
        if(root == null)
            return  m_list;
        else{
            m_list.add(root.val);
            if(root.left != null)
                m_list.addAll(preorderTraversal(root.left));
            if(root.right != null)
                m_list.addAll(preorderTraversal(root.right));
        }
        return m_list;
    }
}