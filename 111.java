public class Solution {
    public int minDepth(TreeNode root) {
        TreeNode[] queue=new TreeNode[100000];    
        int font=0,rear=1;            
        queue[font]=root;
        if(queue[font]==null)
            return 0;
        queue[font].val=1;         
        while(queue[font]!=null){
            if(queue[font].left!=null){      
                queue[rear]=queue[font].left;
                queue[rear].val=queue[font].val+1;
                rear++;
            }
            if(queue[font].right!=null)      
            {
                queue[rear]=queue[font].right;
                queue[rear].val=queue[font].val+1;
                rear++;
            }
            if(queue[font].left==null && queue[font].right==null){     
                return queue[font].val;
            }else{
                font++;
            }
        }
        return queue[font].val; 
        
    }
}