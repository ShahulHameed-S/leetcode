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
        if(head==null ||head.next==null){
            return ;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        ListNode cur=slow.next;
        slow.next=null;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        ListNode a=head;
        ListNode b=prev;
        while(b!=null){
            ListNode t1=a.next;
            ListNode t2=b.next;
            a.next=b;
            b.next=t1;
            a=t1;
            b=t2;
        }
    }
}