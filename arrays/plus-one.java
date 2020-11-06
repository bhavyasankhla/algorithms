/**

66. Plus One
Easy

1858

2694

Add to List

Share
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9


**/


class Solution {
    public int[] plusOne(int[] digits) {
        
        int l = digits.length;
        
        int lastDigit = digits[l-1] + 1;
        int carryover = lastDigit/10;
        
        if(lastDigit > 9) {
            digits[l-1] = lastDigit%10;            
            l--;
            while(carryover != 0 && l>0) {
                int temp = digits[l-1] + carryover;
                lastDigit = temp%10;
                carryover = temp/10;
                digits[l-1] = lastDigit;
                l--;
            }
        } else {
            digits[l-1] = lastDigit;
        }
        
        if(carryover != 0) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = carryover;
            for(int i = 1; i<digits.length+1; i++) {
                newDigits[i] = digits[i-1];
            }
            return newDigits; 
        }
        
        return digits;
    
        
    }
}
