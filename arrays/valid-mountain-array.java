/**

https://leetcode.com/problems/valid-mountain-array/

941. Valid Mountain Array
Easy

445

74

Add to List

Share
Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]


 

Example 1:

Input: [2,1]
Output: false
Example 2:

Input: [3,5,5]
Output: false
Example 3:

Input: [0,3,2,1]
Output: true
 

Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000 

**/


class Solution {
    public boolean validMountainArray(int[] A) {
        
            if(A.length < 3) {
                return false;             
            }
         
            int i =1;
            boolean increased = false;
            boolean decreased = false;
        
            for ( i =1; i<A.length;i++) {
                    if(A[i] > A[i-1] && !increased)    {
                             increased = true;
                     }
                    
                     if(A[i] == A[i-1])    {
                             return false;
                     }
                        if(A[i] < A[i-1])    {
                             break;
                     }
                                      
            }   
            
            for (; i<A.length;i++) {
                    if(A[i] < A[i-1] && !decreased)    {
                             decreased = true;
                     }
 
             if(A[i] == A[i-1])    {
                     return false;
             }
                    
                    if(A[i] > A[i-1])    {
                     return false;
             }
        }   
            
        return decreased && increased;
    }
}
