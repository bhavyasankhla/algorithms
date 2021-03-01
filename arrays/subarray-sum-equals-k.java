/**

https://leetcode.com/problems/subarray-sum-equals-k/submissions/

https://www.youtube.com/watch?v=AmlVSNBHzJg&t=185s&ab_channel=NickWhite



560. Subarray Sum Equals K
Medium

6692

233

Add to List

Share
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107



**/


class Solution {
    public int subarraySum(int[] nums, int k) {
            
            if(nums.length == 0) {
                    return 0;
            }
            
            int res = 0;
            
            Map<Integer, Integer> map = new HashMap<>();
            // mapping the sum till that itertation in the array to the number of times that sum has been seen till now. 
            
            // to start with, sum is 0 before starting, so adding that to the map
            
            map.put(0,1);
            int sum = 0;
            
            
            for(int i = 0; i<nums.length; i++) {
                    
                    sum += nums[i];
                    
                    if(map.containsKey(sum - k)) {
                            res += map.get(sum-k);
                    }
                    
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            
            return res;
            
    }
}


