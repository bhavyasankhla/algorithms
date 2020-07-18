/* package codechef; // don't place package name! */

// https://practice.geeksforgeeks.org/viewSol.php?subId=27843833834872&pid=282&user=SHASHANK%20GOYAL

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{   
	    
      String s = "a.b.c.d";
  		
      String[] a = s.split("\\.");
	  	int i;
  		
      for( i = a.length - 1; i > 0; i--) {
	  	    System.out.print(a[i] + '.');
		  }
      
  		System.out.print(a[i]);
		
	  	permutations("abc", 0);
		
	}
	
}
