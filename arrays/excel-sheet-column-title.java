/**
https://leetcode.com/problems/excel-sheet-column-title/


168. Excel Sheet Column Title
Easy

1591

292

Add to List

Share
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
Example 4:

Input: columnNumber = 2147483647
Output: "FXSHRXW"
**/

class Solution {
    public String convertToTitle(int n) {
            
            StringBuilder result = new StringBuilder();
        
            while(n>0) {
                    n--;
                    result.insert(0, (char) (n%26 + 'A'));
                    n /= 26;
            }
            return result.toString();
        
    }
}
