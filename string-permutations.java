// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{   
	    permute("abc", 0, 2);
		
	}
	
	public static void permute(String s, int l, int r) {
	    if(l == r) {
	        System.out.println(s);
	    } else {
	        for(int i = l; i<=r; i++) {
	            s = swap(s, l, i);
	            permute(s, l+1, r);
	            s = swap(s, l, i);
	        }
	    }
	}
	
	public static String swap(String s, int l, int r) {
	    char[] ch = s.toCharArray();
	    char temp = ch[l];
	    ch[l] = ch[r];
	    ch[r] = temp;
	    return String.valueOf(ch);
	}
}

// Output 
/** 
abc
acb
bac
bca
cba
cab
**/
