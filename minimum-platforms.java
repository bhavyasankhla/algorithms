/* package codechef; // don't place package name! */

// https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception {
	    int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
        int n = arr.length; 
        System.out.println("Minimum Number of Platforms Required = "
                        + findPlatform(arr, dep, n)); 
	}
	
	static int findPlatform(int arr[], int dep[], int n) { 
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i =0, j =0, p=0;
        int max = 1;
        
        while( i<n && j<n) {
            if(arr[i] <=dep[j]) {
                i++;
                p++;
                max = Math.max(max, p);
            } else {
                j++;
                p--;
            }
        }
        
        return max;
        
    }
}
