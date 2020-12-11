/**

125. Valid Palindrome
Easy

1608

3355

Add to List

Share
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII character

**/

class Solution {
    public boolean isPalindrome(String s) {
            
            if(s==null) {
                    return false;
            }
            
            if(s.isEmpty()) {
                    return true;
            }
            int l = s.length();
            
            s=s.toLowerCase();
        
            int left = 0, right = l-1;
            
            while(left < right && left >=0 && right <=l-1) {
                    
                    while(!iAlphanumeric(s.charAt(left)) && left<right) 
                            left++;
                    
                    while(!iAlphanumeric(s.charAt(right)) && left<right) 
                            right--;
                    
                    if(s.charAt(left) != s.charAt(right)) {
                            return false;
                    }
                    
                    left++;
                    right--;
                    
                    
            }
            
            return true;
        
    }
        
        public boolean iAlphanumeric(char ch){
                if ( (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') ) {
                        return true;
                }                
                return false;
        }
}
