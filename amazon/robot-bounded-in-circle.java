/**
https://leetcode.com/problems/robot-bounded-in-circle/

1041. Robot Bounded In Circle
Medium

952

288

Add to List

Share
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.

**/

class Solution {
        
        int x=0,y=0; 
        int a=0,b=1; // default direction is UP - (0,1)
            
        public boolean isRobotBounded(String instructions) {
            
            
            if(util(instructions)) {
                    return true;
            } else {
                    int tries = 3;
                    while(tries-->0) {
                            if(util(instructions)) {
                                    return true;
                            }
                    }
            }
            
            return false;
        
        }
        
        private boolean util(String instructions) {
        // private boolean util(String instructions, int x, int y, int a, int b) {
                
                for(int i = 0; i<instructions.length(); i++) {
                    
                    char ch = instructions.charAt(i);
                    
                    if(ch=='G') {
                            
                            x += a;
                            y += b;
                            
                    } else if(ch=='L') {
                                
                            int temp = a;
                            a = (-1) * b;
                            b = temp;
                            
                    } else {
                            
                            int temp = a;
                            a = b;
                            b = (-1) * temp;
                            
                    }
            
                }
                
                if(x==0 && y==0) {
                    return true;
                }
                
                return false;
        }
        
}
