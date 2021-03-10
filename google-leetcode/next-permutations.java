/**

https://leetcode.com/problems/next-permutation/


31. Next Permutation
Medium

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
**/

class Solution {
    public void nextPermutation(int[] nums) {
            
            int l = nums.length;
            
            boolean done = false;
            boolean reverseRight = false;

            int i = l-1, pos = 0, track = 0;
            
            for(; i>0; i--) {
                    if(nums[i-1] < nums[i]) {
                            
                            
                            int temp = nums[i-1];
                            
                            int k = i+1;
                            
                            pos = i;
                            
                            while(k<l) {
                                    if(nums[k] <= nums[pos] && nums[k] > temp) {
                                            pos = k;
                                    }                                    
                                    k++;
                            }
                            
                            nums[i-1] = nums[pos];
                            nums[pos] = temp;
                            
                            done = true;
                            reverseRight = true;
                            break;
                    }
            }
            
            if(reverseRight) {
                    int left = i, right = l-1;
                    while(left < right) {
                            int temp = nums[left];
                            nums[left] = nums[right];
                            nums[right] = temp;
                            left++;
                            right--;
                    }

            }
            
            if(!done) {
                    int left = 0, right = l-1;
                    while(left < right) {
                            int temp = nums[left];
                            nums[left] = nums[right];
                            nums[right] = temp;
                            left++;
                            right--;
                    }
            }
            
        
    }
}
