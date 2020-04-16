// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		int a = scanner.nextInt();
		
		while(a > 0) {
		    int b = scanner.nextInt();
		    int[] a1 = new int[b];
		    int i=0;
		    for(i = 0;i<b;i++) {
		        a1[i] = scanner.nextInt();
		    }
		    
		    int rightSum = 0, leftSum = 0;
		    for(i = 0;i<b;i++) {
		        rightSum+=a1[i];
		    }
	        System.out.print(findIndex(a1, leftSum, rightSum, b));
	        if(a != 1) {
	            System.out.println();
	        }
	        a--;
		}  
		
	}
	
	public static int findIndex(int[] a1, int leftSum, int rightSum, int n) {
	    for(int i=0; i<n;i++) {
	        rightSum-=a1[i];
	        if(rightSum == leftSum) {
	            return i+1;
	        }
	        leftSum+=a1[i];
	    }
	    return -1;
	}
}
