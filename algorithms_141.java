/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode a = head;
        ListNode b = head.next;
        while(a != null && b != null) {
            if(a == b) return true;
            else {
                a = a.next;
                if(b.next == null || b.next.next == null) return false;
                b = b.next.next;
            }
        }
        return false;
    }
}