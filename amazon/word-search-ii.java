/**
https://leetcode.com/problems/word-search-ii/

**/

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
            
            int rows = board.length;
            int cols = board[0].length;
            
            List<String> list = new ArrayList<>();
            
            for(String word : words) {
                    
                wordLoop:                    
                    
                for(int i = 0; i<rows; i++) {
                    
                        for(int j = 0; j<cols; j++) {
                            
                            if(board[i][j] == word.charAt(0)) {
                        
//                                    char[][] copyOfBoard = new char[rows][cols];
//                                    for(int r = 0; r<rows; r++) {                                           
//                                            copyOfBoard[r] = Arrays.copyOf(board[r], cols);
//                                    }
                                
                                // We are already restoring the characters after check in findWord method so no need to make new copy of the 2D array
                                // This check below 
                                //                 char c = board[row][col];
                                    //                board[row][col] = '*';  
                                   
                                   if(findWord(copyOfBoard,i,j,word,0) && !list.contains(word)) {
                                           list.add(word);
                                           break wordLoop;
                                   }
                                    
                            }
                    }
                } 
                   
            }
            
                
            return list;
    }
        
        public boolean findWord(char[][] board, int row, int col, String word, int current) {
                
                if(row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1 || board[row][col] == '*') {                 
                        return false;              
                }  
      
                if(!(board[row][col] == word.charAt(current))) {
                    return false;    
                }
                
                char c = board[row][col];
                board[row][col] = '*';  
                
              
                if(word.length()-1 == current) {
                        return true;
                }
                
                boolean res =  
                findWord(board, row+1, col, word, current+1) ||
                findWord(board, row, col+1, word, current+1) ||
                findWord(board, row-1, col, word, current+1) ||
                findWord(board, row, col-1, word, current+1);
                
                board[row][col] = c;  
                
                return res;
                
        }
}
