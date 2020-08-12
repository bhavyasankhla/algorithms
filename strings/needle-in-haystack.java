// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/

/**

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Constraints:

haystack and needle consist only of lowercase English characters.

**/


class Solution {
    public int strStr(String haystack, String needle) {
            
            if(needle == null || needle.length()==0) {
                    return 0;
            }
            
            if(haystack == null || haystack.length()==0) {
                    return -1;
            }
           
            for (int i = 0; i< haystack.length()-needle.length()+1; i++) {
                    
                    if(haystack.charAt(i) == needle.charAt(0)) {
                            int j = i+1; 
                            int k = 1;
                            
                            while(j<needle.length()+i) {
                              
                                if(haystack.charAt(j) != needle.charAt(k)) {
                                       break;
                               }                            
                                k++;
                               j++;     
                            }
                            if(k==needle.length()) {
                                    return i;                                    
                        }
                    }
            }
            return -1;
            
        
    }
}
