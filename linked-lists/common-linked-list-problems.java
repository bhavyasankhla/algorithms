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

    // Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
    /**
    Example 1:

    Input: head = [4,5,1,9], node = 5
    Output: [4,1,9]
    Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
    Example 2:

    Input: head = [4,5,1,9], node = 1
    Output: [4,5,9]
    Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

    **/
    
        public void deleteNode(ListNode node) {              
            node.val = node.next.val;
            node.next = node.next.next;        
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode previous = head, fast=head, slow=head;
            int temp = n;
            while(temp>0) {
                    temp--;
                    fast = fast.next;
            }
            if(fast == null) { // end of list has been reached
                    // and node to be removed is the head. 
                    head = head.next;
                    return head;
            } else {
                    // till fast reached the end, slow will reach nth node.                     
                        while(fast != null) {
                            previous = slow;
                            slow = slow.next;
                            fast = fast.next;
                        }
                previous.next = slow.next;
                    return head;
            }
                 
    }
    
    
    public ListNode reverseList(ListNode head) {
        ListNode current = head, previous = null, next = null;
        
            while(current != null) {
                    next = current.next;
                    current.next = previous;                    
                    previous = current;
                    current = next;
            }
            
            return previous;
    }
}
