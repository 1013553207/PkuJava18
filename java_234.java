/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
                //int length
        if(head == null) return  true;
        ListNode oHead = new ListNode(head.val);
        ListNode eNode = head.next;
        while(eNode != null){
            ListNode tNode = new ListNode(eNode.val);
            tNode.next = oHead;
            oHead = tNode;
            eNode = eNode.next;
        }
        ListNode tmp_1node = head; ListNode tmp_2node = oHead;
        while(tmp_1node != null && tmp_2node != null) {
              if(tmp_1node.val != tmp_2node.val)
                  return  false;
              tmp_1node = tmp_1node.next;
              tmp_2node = tmp_2node.next;
        }
        return true;
        
    }
}