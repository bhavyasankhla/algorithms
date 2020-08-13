/**

Merge two sorted linked lists and return it as a new sorted list. 
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            
            return merge(l1, l2);
        
    }
        
        public ListNode merge(ListNode A, ListNode B) {
                if(A == null)
                        return B;
                if(B == null) {
                        return A;
                }
                
                if(A.val <= B.val) {
                        A.next = merge(A.next, B);
                        return A;
                } else {
                        B.next = merge(A, B.next);
                        return B;
                }
        }
}
