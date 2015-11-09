/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode node = head;
        int val = node.val;
        while (node.next != null) {
            ListNode n = node.next;
            while(n.val == val) {
                if(n.next == null) {
                    node.next = null;
                    return head;
                }
                n.val = n.next.val;
                n.next = n.next.next;
            }
            node = n;
            val = n.val;
        }
        return head;
    }
}