/**
https://leetcode.com/problems/meeting-rooms-ii/

253. Meeting Rooms II
Medium

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106

**/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int res = 0; int l = intervals.length;
        
        int[] start = new int[l];
        int[] end = new int[l];
        int i= 0;
        
        for( i = 0; i < intervals.length; i++) {            
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int currentCount = 0, j=0;
        i=0;
      
        // Exactly the way we solved number of min platformas for train/railways
        
        while(i < l && j < l) {
            
            if(start[i] < end[j]) {
                currentCount++;
                i++;
                res = Math.max(res, currentCount);
            } else {
                j++;
                currentCount--;
            }
        }
        
        
        
        return res;
        
    }
}
