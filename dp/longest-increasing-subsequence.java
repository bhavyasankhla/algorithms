/**
https://leetcode.com/problems/longest-increasing-subsequence/

300. Longest Increasing Subsequence
Medium

6622

152

Add to List

Share
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up:

Could you come up with the O(n2) solution?
Could you improve it to O(n log(n)) time complexity?
**/


class Solution {
    public int lengthOfLIS(int[] nums) {
        
            if(nums.length==1) {
                    return 1;
            }
            
            int[] dp = new int[nums.length];
            
            // Length of LIS at any element is atleast one. 
            
            Arrays.fill(dp, 1);
            
            int i = 1, j = 0, result = 0, l = nums.length;
            
            for(i=1; i<l; i++) {
                    for(j=0;j<i;j++) {
                            if(nums[j]<nums[i]) {
                                    dp[i] = Math.max(dp[i], dp[j]+1);
                            }
                    }
                    result = Math.max(result, dp[i]);
            }
            
            return result;
     
     
//            2nd approach
     
        
            
     
     
            ArrayList<Integer> list = new ArrayList<>();            
            list.add(nums[0]);
            
            for(int i = 1; i < nums.length; i++) {
                    int num = nums[i];
                    if(num > list.get(list.size()-1)) {
                            list.add(num);
                    } else {
                            // Find the first element in list that is greater than or equal to num
                            int j = 0;
                            while( list.get(j) < num) {
                                    j++;
                            }
                            list.set(j, num);
                    }
                    
            }
            
            return list.size();
     

    }

}
