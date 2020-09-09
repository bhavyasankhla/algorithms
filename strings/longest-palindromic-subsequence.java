/**
516. Longest Palindromic Subsequence
Medium

2251

190

Add to List

Share
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
 

Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.

**/

class Solution {
    public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] map = new int[n][n];
            
            for(int i = 0; i < n; i++) {
                Arrays.fill(map[i], -1);        
            }
            
            return driver(s, 0, s.length()-1, map);        
    }
        
        public int driver(String s, int left, int right, int[][] map) {
                if(map[left][right] != -1) {
                        return map[left][right];
                }
                if(left>right) {
                        map[left][right] = 0;
                        return 0;
                } 
                if(left==right) {
                        map[left][right] = 1;
                        return 1;
                }
                if(s.charAt(left) == s.charAt(right)) {
                        map[left][right] =  2 + driver(s, left+1, right-1, map);
                } else {
                        map[left][right] = Math.max(driver(s, left+1, right, map), driver(s, left, right-1, map));
                }
                return map[left][right];
        }
}
