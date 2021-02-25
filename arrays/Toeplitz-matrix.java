/**

https://leetcode.com/discuss/interview-experience/124626/Google-onsite-interview-questions/

766. Toeplitz Matrix
Easy

1295

89

Add to List

Share
Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

 

Example 1:


Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:


Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.

**/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
            
            int rows = matrix.length;
            int cols = matrix[0].length;
            
            if(rows==1 && cols == 1 ) {
                    return true;
            }
            
            
            for(int i=0; i<rows-1; i++) {
                    for(int j = 0; j<cols-1; j++) {
                            boolean res = checkDiagonal(matrix, i , j);
                            if(!res) {
                                    return false;
                            }
                    }
            }
            
            return true;
        
    }
     
        
        private boolean checkDiagonal(int[][] matrix, int i, int j) {
                if(i == matrix.length-1 || j == matrix[0].length-1) {
                        return true;
                }
                
                if(matrix[i][j] != matrix[i+1][j+1] ) {
                        return false;
                }
                
                return checkDiagonal(matrix, i+1, j+1);
        }
        
        
        
}
