// Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note: You are not suppose to use the library's sort function for this problem.

// Example:

// Input: [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
// https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/


class Solution {
    public void sortColors(int[] nums) {
            
            int high = nums.length - 1;
            int low = 0, mid = 0;
                       
            while(mid <= high) {
                    if(nums[mid] == 0) {
                            int temp = nums[low];
                            nums[low] = nums[mid];
                            nums[mid] = temp;
                            mid++;
                            low++;
                    } else if (nums[mid] == 1) {
                            mid++;
                    } else {
                            int temp = nums[high];
                            nums[high] = nums[mid];
                            nums[mid] = temp;
                            high--;
                    }
            }        
    }
}
