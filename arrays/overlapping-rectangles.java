/**

Given two rectangles, find if the given two rectangles overlap or not. 
A rectangle is denoted by providing the x and y co-ordinates of two points: the left top corner and the right bottom corner of the rectangle. 
Two rectangles sharing a side are considered overlapping.

Note : It may be assumed that the rectangles are parallel to the coordinate axis.

rectanglesOverlap

Input:
The first integer T denotes the number of testcases. For every test case, there are 2 lines of input. The first line consists of 4 integers: denoting the co-ordinates of the 2 points of the first rectangle. The first integer denotes the x co-ordinate and the second integer denotes the y co-ordinate of the left topmost corner of the first rectangle. The next two integers are the x and y co-ordinates of right bottom corner. Similarly, the second line denotes the cordinates of the two points of the second rectangle in similar fashion.

Output:
For each testcase, output (either 1 or 0) denoting whether the 2 rectangles are overlapping. 1 denotes the rectangles overlap whereas 0 denotes the rectangles do not overlap.

Constraints:
1 <= T <= 10
-104 <= x, y <= 104

Example:
Input:
2
0 10 10 0
5 5 15 0
0 2 1 1
-2 -3 0 2

Output:
1
0

Explanation:
Testcase 1: According to the coordinates given as input ,two rectangles formed overlap with each other and thus answer returns 1.
**/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner (System.in);
		int t = s.nextInt();
		while(t-->0) {
		    int[] a = new int[4];
		    int[] b = new int[4];
		    
		    for(int i = 0; i < 4; i++) {
		        a[i] = s.nextInt();
		    }
		    
		    for(int i = 0; i < 4; i++) {
		        b[i] = s.nextInt();
		    }
		    
		  
		    
		    boolean x = true;
		    if(a[0] > b[2] || a[2] < b[0]) {
		        x = false;
		    }
		    
		    boolean y = true;
		    
		    if(a[3] > b[1] || a[1] < b[3]) {
		        y = false;
		    }
		    
		    if(x&&y) {
		        System.out.println(1);
		    } else {
		        System.out.println(0);
		    }
		    
		    
		   
		}
	}
}

