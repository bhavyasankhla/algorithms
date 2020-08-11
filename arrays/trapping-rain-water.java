/**
Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.
**/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int t = Integer.parseInt(br.readLine());
		
		while(t>0) {
		    t--;
		    int n = Integer.parseInt(br.readLine());
		    Integer[] a = new Integer[n];
            String[] s1=br.readLine().trim().split(" ");
            for(int i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(s1[i]);
            }
            int maxL = a[0], maxR=a[n-1];
            Integer[] maxLArr = new Integer[n];
            Integer[] maxRArr = new Integer[n];
            for(int i =1; i<n-1;i++) {
                maxL = Math.max(a[i], maxL);
                maxLArr[i]=maxL;
                maxR = Math.max(a[n-i-1], maxR);
                maxRArr[n-i-1]=maxR;
            }
            int res = 0;
            for(int i =1; i<n-1;i++) {
                int min = Math.min(maxRArr[i],maxLArr[i]);
                res+=min-a[i];
            }
            System.out.println(res);
		}
	}
}
