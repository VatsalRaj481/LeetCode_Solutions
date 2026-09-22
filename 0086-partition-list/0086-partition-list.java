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
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);
        ListNode less=lessDummy,greater=greaterDummy,temp=head;
        while(temp!=null){
            if(temp.val<x){
                less.next=temp;
                less=less.next;
            }
            else{
                greater.next=temp;
                greater=greater.next;
            }
            temp=temp.next;
        }
        less.next=greaterDummy.next;
        greater.next=null;
        return lessDummy.next;
    }
}