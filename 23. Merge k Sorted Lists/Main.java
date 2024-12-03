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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null ;
        }
        return mergeHelper(lists, 0, lists.length-1) ;
    }
    private ListNode mergeHelper(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        if(start+1 == end) return mergeList(lists[start], lists[end]);
        int mid = start + ((end-start)/2) ;
        ListNode l = mergeHelper(lists, start, mid);
        ListNode r = mergeHelper(lists, mid+1, end);
        return mergeList(l,r);
    }
    private ListNode mergeList(ListNode n1, ListNode n2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy ;
        while (n1 != null && n2 != null){
            if (n1.val < n2.val){
                temp.next = n1 ;
                n1 = n1.next;
            }
            else{
                temp.next = n2 ;
                n2 = n2.next ; 
            }
            temp = temp.next ;
        }
        if(n1 != null){
            temp.next = n1 ;
        }
        if(n2 != null){
            temp.next = n2 ;
        }
        return dummy.next ;
    }
}
