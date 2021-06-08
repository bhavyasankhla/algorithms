/**
 Longest Palindromic Substring
 
 https://www.youtube.com/watch?v=y2BD4MJqV20&ab_channel=NickWhiteNickWhiteVerified
 
 
Medium

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),


**/


class Solution {
    public String longestPalindrome(String s) {
        
        if(s==null || s.length() == 0) {
                return "";
        }        
            
        if(s.length() == 1) {
                return s;
        }
            
            int l = s.length();
            int maxL = 0;
            String longest = "";
            
        for(int i = 0; i<l; i++) {
                
                int len1 = expandFromMiddle(s, i, i);
                int len2 = expandFromMiddle(s, i, i+1);
                int len = Math.max(len1, len2);
                
                if(len > maxL) {
                        
                        int start = i - (len-1)/2;
                        int end = i + (len/2) + 1;
                        
                        longest = s.substring(start, end);
                        maxL = len;
                }
        
        }
            
            
            return longest;
        
    }
    
    public int expandFromMiddle(String s, int left, int right) {
            
            if(s==null || left > right) {
                    return 0;
            }
            
            while( left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left) ) {
                    left--;
                    right++;
            }
            
            return right - left - 1;
    }
    
   
}
