/**

https://www.youtube.com/watch?v=0iQqj5egK9k&ab_channel=NickWhite

https://leetcode.com/problems/decode-string/

394. Decode String
Medium

4636

226

Add to List

Share
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].


**/


class Solution {
    public String decodeString(String s) {
            
            String res = "";
            
            if(s == null || s.length() == 0) {                    
                    return res;
            }
            
            Stack<String> result = new Stack();
            Stack<Integer> counts = new Stack();
            
            int i = 0;
            
            while(i<s.length()) {
                    
                    if(Character.isDigit(s.charAt(i))) {                                                    
                            int count = 0;
                            while(Character.isDigit(s.charAt(i))) {
                                    count = 10*count + (s.charAt(i) - '0');
                                    i++;
                            }
                            counts.push(count);                                                        
                    } else if(s.charAt(i) == '[') {
                            
                            result.push(res);
                            res = "";
                            i++;                            
                    } else if(s.charAt(i) == ']') {
                            
                            StringBuilder sb = new StringBuilder(result.pop());                            
                            Integer count = counts.pop();                            
                            while(count-->0) {
                                    sb.append(res);
                            }                            
                            res = sb.toString();                            
                            i++;
                            
                    } else {                            
                            res += s.charAt(i);
                            i++;
                    }                                         
            }
            
            return res;
        
    }
}
