137. Single Number II

https://leetcode.com/problems/single-number-ii/


Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 

Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Accepted
277,071
Submissions
514,835
Seen this question in a real interview before?

Yes

No

Problems

Pick One

Prev
/310

Next
class Solution {
    public int singleNumber(int[] nums) {
            
            int l = nums.length;
            
            if(l==1) return nums[0];
            
            Arrays.sort(nums);
            
            if(nums[0] != nums[1]) {
                    return nums[0];
            }                       
            
            for(int i=1; i< l-1; i++) {
                    if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                            return nums[i];
                    }
            }
            
            return nums[l-1];
        
    }
}
