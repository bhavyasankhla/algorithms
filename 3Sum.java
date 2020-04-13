//  3Sum
// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.

// Note:

// The solution set must not contain duplicate triplets.

// Example:

// Given array nums = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {             
            
            List<List<Integer>> list = new ArrayList<>();            
            int n = nums.length;
            Arrays.sort(nums);  
            
            for (int i =0 ; i < n-2; i++) {
                
                    if(i > 0 && nums[i] == nums[i-1]) {
                            continue;
                    }
                    
                    int left = i+1;
                    int right = n-1;
                    
                    int complement = -nums[i];
                    
                    while(left < right) {                        
                            int sum = (nums[left]+nums[right]);
                            if( sum == complement) {
                                    
                                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                                    
                                    left++;
                                    right--;
                                    
                                    while(nums[left] == nums[left-1] && left < right) {
                                            left++;
                                    }                            

                                    while(nums[right] == nums[right+1] && right > left) {
                                            right--;
                                    }
                             
                            } else if(sum > complement) {
                                    right--;
                            } else {
                                    left++;
                            }                                                                           
                    }
            }
            
            return list;
            
    }
}
