public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null?true:isSymmetric(root.left, root.right);
    }
    
    
    public  boolean isSymmetric(TreeNode left,TreeNode right) {
	   if(left==null&&right==null)
		   return true;
	   else{
		   if(left==null||right==null)
			   return false;
		   else{
			   return (left.val==right.val&&isSymmetric(left.left,right.right)&&isSymmetric(left.right, right.left));
			   
    }
}
}
}