/**
https://leetcode.com/problems/max-area-of-island/
695. Max Area of Island
Medium

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
**/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
            
            int rows = grid.length;
            int cols = grid[0].length;
            
            
            int res = 0;
            
            for(int i = 0; i<rows; i++) {
                    for(int j = 0; j<cols; j++) {
                            if(grid[i][j] == 1) {
                                    res = Math.max(res, expand(i,j, grid));
                            }
                    }
            }
            
            return res;
        
    }
        
        public int expand(int i, int j, int[][] grid) {
                
                int rows = grid.length;
                int cols = grid[0].length;
                
                if(i<0 || j<0 || i>=rows || j>=cols) {
                        return 0;
                }
                
                grid[i][j] = -1;
                
                int res = 0;
                
                if(i+1 < rows && grid[i+1][j] == 1) {
                      res += expand(i+1,j, grid);       
                }
                
                if(j+1 < cols && grid[i][j+1] == 1) {
                      res += expand(i,j+1, grid);       
                }
                
                if(i-1 >=0 && grid[i-1][j] == 1) {
                      res += expand(i-1,j, grid);       
                }
                
                if(j-1 >= 0 && grid[i][j-1] == 1) {
                      res += expand(i,j-1, grid);       
                }
        
                return 1+res;
        }
}
