/**
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. 
The sum list is a linked list representation of the addition of two input numbers.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the new list.

Expected Time Complexity: O(N) + O(M)
Expected Auxiliary Space: O(N) + O(M)

Constraints:
1 <= N, M <= 5000

**/

// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node addLists(Node first, Node second){
        
        if(first == null && second == null) {
            return null;
        }
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        
        if(first == null) {
            return second;
        }
        
        if(second==null) {
            return first;
        }
        
        while(first != null) {
            s1.push(first.data);
            first = first.next;
        }
        
        while(second != null) {
            s2.push(second.data);
            second = second.next;
        }
        
        int carry = 0, sum = 0;
        
        while(!s1.empty() && !s2.empty() ) {
            int a = s1.pop();
            int b = s2.pop();
            sum = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            s3.push(sum);
        }
        
        while(!s1.empty()) {
            int a = s1.pop();
            sum = (a+carry)%10;
            carry = (a+carry)/10;
            s3.push(sum);
        }
        
        while(!s2.empty()) {
            int a = s2.pop();
            sum = (a+carry)%10;
            carry = (a+carry)/10;
            s3.push(sum);
        }
        
        if(carry != 0) {
            s3.push(carry);
        }
        
        
        Node res = null, head = null;
        
        if(!s3.empty()) {
            int a = s3.pop();
            //System.out.println(a);
            res = new Node(a);
            head = res;
        }
        
        
        while(!s3.empty()) {
            int a = s3.pop();
            //System.out.println(a);
            res.next = new Node(a);
            res = res.next;
        }
        
        return head;
        
    }
}

