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
    public ListNode reverseList(ListNode head) {
        return recursive(null, head);
    }
    private ListNode recursive(ListNode prev, ListNode curr){
        if(curr == null){
            return prev ;
        }
        else{
            ListNode next = curr.next;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        return recursive(prev, curr);
    }
}
