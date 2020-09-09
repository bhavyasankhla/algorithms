/*package whatever //do not write package name here 
Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is S.

Output:

Print the minimum number of characters.

Constraints:

1 ≤ T ≤ 50
1 ≤ S ≤ 40

Example:

Input:
3
abcd
aba
geeks

Output:
3
0
3


Find the length of longest palindromic subsequence.
the ans is length of string minus this number.

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t>0) {
		    
		    t--;
		    
		    String str = br.readLine();
		    if(str==null) {
		        System.out.println(0);
		        continue;
		    }
		    
		    int n = str.length();
            int[][] map = new int[n][n];
            
            for(int i = 0; i < n; i++) {
                Arrays.fill(map[i], -1);        
            }
            
            System.out.println(str.length()-driver(str, 0, n-1, map));
		    
		}
		
		
	}
	
	public static int driver(String s, int left, int right, int[][] map) {
                if(map[left][right] != -1) {
                        return map[left][right];
                }
                if(left>right) {
                        map[left][right] = 0;
                        return 0;
                } 
                if(left==right) {
                        map[left][right] = 1;
                        return 1;
                }
                if(s.charAt(left) == s.charAt(right)) {
                        map[left][right] =  2 + driver(s, left+1, right-1, map);
                } else {
                        map[left][right] = Math.max(driver(s, left+1, right, map), driver(s, left, right-1, map));
                }
                return map[left][right];
        }
}
