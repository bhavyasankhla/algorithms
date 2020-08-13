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

    // O(n) approach with O(1) space 
    
     public boolean isPalindrome(ListNode head) {
            
            if(head == null) {
                    return true;
            }
            
            ListNode slow = head, fast = head;
            
            while(fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
            }
            
            // if the size of LL is odd, fast wont be null after above loop.
            ListNode mid_node = null;
            
            if(fast != null) {
                mid_node = slow; 
                slow = slow.next;
            }
            
            // if it is even, fast will be null and slow will point to start of second half of LL
            
            // Reversing the second half LL
            
            ListNode previous = null, current = slow, next = null;
            
            while(current != null) {
                    next = current.next;
                    current.next = previous;
                    previous = current;
                    current = next;
            }
            
            // previous will now be the head of reversed second half of LL
            
            while(previous != null) {
                    if(previous.val != head.val) {
                            return false;
                    }
                    previous = previous.next;
                    head = head.next;                    
            }
                
            return true;
               
    }

    // STACK Approach 
    public boolean isPalindrome(ListNode head) {
            
            if(head == null) {
                    return true;
            }
            
            Stack<Integer> stack = new Stack<>();
            
            ListNode temp = head;
            
            while(temp != null) {
                    stack.push(temp.val);
                    temp = temp.next;
            }
            
            temp = head;
            
            while(temp != null) {
                    int data = stack.pop();
                   
                    if(data != temp.val) {
                            return false;
                    }
                    temp = temp.next;
            }
            
            return true;
            
        
    }
}
