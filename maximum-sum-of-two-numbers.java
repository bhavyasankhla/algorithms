// Given an array A consisting of N integers, returns the maximum sum of two numbers whose
// digits add up to an equal sum. 
// if there are not two numbers whose digits have an equal sum, the function should return -1.

/**
 * Example
Example1:
Input:
A = [51, 71, 17, 42]
Output: 93
Explanation: There are two pairs of numbers whose digits add up to an equal sum: (51, 42) and (17, 71), The first pair sums up  to 93
Example2:
Input:
A = [42, 33, 60]
Output: 102
Explanation: The digits of all numbers in A add up the same sum, and choosng to add 42 and 60 gives the result 102
Example3:
Input:
A = [51, 32, 43]
Output: -1
Explanation: All numbers in A have digits that add up to different, unique sums
**/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] a = {51, 71, 17, 42};
		
		Arrays.sort(a);
		
		int n = a.length;
		
		int max = -1;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for ( int i = n-1; i>=0; i--) {
			int num = a[i];
			int sum = 0;
			
			while(num>0) {
				int digit = num%10;
				sum += digit;
				num /= 10;
			}
			
			if(map.containsKey(sum)) {
				int tempSum = a[i] +  map.get(sum);	
				max = Math.max(max, tempSum);
			}
			
			map.put(sum, a[i]);
		}
		
		System.out.println(max);
	}
}
