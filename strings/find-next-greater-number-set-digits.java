/**
556. Next Greater Element III
https://www.geeksforgeeks.org/find-next-greater-number-set-digits/

Add to List


Given a positive 32-bit integer n, you need to find the smallest 32-bit integer 
which has exactly the same digits existing in the integer n and is greater in value than n. 
If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21
 

Example 2:

Input: 21
Output: -1 
**/


class Solution {
    public int nextGreaterElement(int n) {                          
                
                String s = String.valueOf(n);                                
                int l = s.length();
            
                if(l == 1) {
                      return -1;  
                }
            
                int[] nums = new int[l];
                int i = 0;
                for ( ; i<l; i++) {
                        nums[i] = Character.getNumericValue(s.charAt(i));
                }                           
                
                for(i = l-1; i>0; i--) {
                        
                        if(nums[i-1] < nums[i]) {                                                        
                                
                                int j = i+1; 
                                int k = i;                                 
                                
                                while(j<l) {
                                        
                                        if(nums[j] > nums[i-1] && nums[j]<nums[k]) {                                                                    
                                          k = j;        
                                        }
                                        
                                        j++;
                                }
                                
                                int temp = nums[k];
                                nums[k] = nums[i-1];
                                nums[i-1] = temp;
                                
                                break;
                        }
                }
            
                if(i == 0) { // Descending number
                        return -1;
                }                            
                
                Arrays.sort(nums, i, l);
                 
            
                int  res = 0;
                
                for(i = 0; i<l; i++) {                                
                        
                        long tempRes = (long) nums[i] + (long) res*10;        
                        
                        if(tempRes >= Integer.MAX_VALUE) {
                                return -1;
                        }
                        
                        res = (int) tempRes;
                        
                }

                return res;                           
        }
            
    }
