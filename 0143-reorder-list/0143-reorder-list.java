/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second = slow.next;
        slow.next=null;
        ListNode current = second,prev=null,next;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        second=prev;
        ListNode first=head;
        while(first!=null && second!=null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next=second;
            second.next=firstNext;
            first=firstNext;
            second=secondNext;
        }
    }
}