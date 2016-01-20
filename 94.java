public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        Stack<TreeNode> sk = new Stack<TreeNode>();    //保存每个根节点
        if(root==null)          //为空直接返回
            return res;
        TreeNode p=root;
        //sk.push(p);                   
        while(!sk.empty()||p!=null){     //中序遍历，如果栈为空且p为空说明完成树的遍历
            //while(p.left!=null)
            while(p!=null){             
                sk.push(p);
                p=p.left;
            }
            if (!sk.empty()){       
                p = sk.peek();
                sk.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;

    }
}