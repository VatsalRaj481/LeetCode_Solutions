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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        int crit=2;
        ListNode temp = head.next;
        ListNode prev=head,post=temp.next;
        while(temp.next!=null){
            if((temp.val<prev.val && temp.val<post.val) ||
                (temp.val>prev.val && temp.val>post.val)){
                nodes.add(crit);
            }
            crit++;
            prev=temp;
            temp=temp.next;
            post=temp.next;
        }
        if(nodes.size()<2){
            return new int[]{-1,-1};
        }
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<nodes.size()-1;i++){
            int diff = Math.abs(nodes.get(i)-nodes.get(i+1));
            min=Math.min(diff,min);
        }
        max=nodes.get(nodes.size()-1)-nodes.get(0);
        return new int[]{min,max};
    }
}