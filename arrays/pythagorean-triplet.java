/*package whatever //do not write package name here */

// Find P T 

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
		    
		    if(checkPT(a, n)) {
		        System.out.println("Yes");
		    } else {
		        System.out.println("No");
		    }
		}
		
	}
	// 3,2,4,6,5 
	// 6,5,4,3,2
	public static boolean checkPT(Integer[] a, int n) {
	   Arrays.sort(a, Collections.reverseOrder());
	    for(int i = 0; i<n-2; i++) {
	        if(i>0 && a[i] == a[i-1]) {
	            continue;
	        }
	        double target = Math.pow(a[i], 2);
	        Map<Double, Integer> map = new HashMap<>();
	        for(int j=i+1;j<n;j++) {
	            if(j>i+1 && a[j] == a[j-1]) {
	                continue;
	            }
	            double sq = Math.pow(a[j], 2);
	            double complement = target-sq;
	            if(map.containsKey(complement)) {
	                return true;
	            }
	            map.put(sq, j);
	        }
	    }
	    return false;
	}
}
