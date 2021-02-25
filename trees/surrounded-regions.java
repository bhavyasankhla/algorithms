/**
130. Surrounded Regions


https://leetcode.com/problems/surrounded-regions/


https://www.youtube.com/watch?v=ztTLGMeleco&t=204s&ab_channel=NickWhite


Medium

2521

748

Add to List

Share
Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

**/

class Solution {
    public void solve(char[][] board) {
        
            
            int rows = board.length;
            int cols = board[0].length;
            
            
            for ( int j=0; j<cols; j++) {
                    
                    if(board[0][j] == 'O') {
                            expand(board,0,j);    
                    }
                    
                    if(board[rows-1][j] == 'O') {
                           expand(board,rows-1,j);     
                    }
                    
            }
            
            for (int i=1; i<rows-1; i++) {
                    
                    if(board[i][0] == 'O') {
                        expand(board,i,0);    
                    }
                    
                    if(board[i][cols-1] == 'O') {
                            expand(board,i,cols-1);    
                    }
                    
            }
            
            
            for (int i=0; i<rows; i++) {
                    for ( int j=0; j<cols; j++) {
                            if(board[i][j] == 'O') {
                                    board[i][j] = 'X';
                            } else if(board[i][j] == '*') {
                                    board[i][j] = 'O';
                            } 
                    }
                    
            }
            
    }
        
        private void expand(char[][] board, int i, int j) {
                    if(i < 0 || j < 0 || i>board.length-1 || j > board[0].length-1) {
                            return;
                    }
                    
                    board[i][j] = '*';
                    
                    if(i>0 && board[i-1][j] == 'O') {
                          expand(board, i-1,j);  
                    }
                
                        if(i < board.length-1 && board[i+1][j] == 'O') {
                          expand(board, i+1,j);  
                    }
                
                if(j>0 && board[i][j-1] == 'O') {
                          expand(board, i,j-1);  
                    }
                
                if( j < board[0].length-1 && board[i][j+1] == 'O') {
                          expand(board, i,j+1);  
                    }
                            
                            
                
                            
                            
            }
}
