/**

33. Search in Rotated Sorted Array
Medium

5678

494

Add to List

Share
You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

**/


class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length  == 0) {
                return -1;
        }
        return binarySearch(nums, 0, nums.length-1, target);
            
    }
        
        public int binarySearch(int[] nums, int start, int end, int target) {
                if(start > end) {
                        return -1;
                }
                
                if(start == end) {
                        if(nums[start] == target) {
                                return start;
                        } else {
                                return -1;
                        }
                }
                
                int middle = (start+end)/2;
                if(nums[middle]==target) {
                        return middle;
                }
                
                // if this portion is sorted 
                if(nums[start] < nums[end]) {
                        if(nums[middle] > target) {
                             return  binarySearch(nums, start, middle, target);  
                        } else {
                                return  binarySearch(nums, middle+1, end, target);  
                        }
                        
                } else {
                        return Math.max(binarySearch(nums, start, middle, target), 
                                       binarySearch(nums, middle+1, end, target)  );
                }
        }
}
