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
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		        int t = Integer.parseInt(br.readLine());
		
			while(t-->0) {

			    String s = String.valueOf(br.readLine());

			    String[] words = s.split("\\.");

			    for(int i = words.length-1; i>0; i--) {
				System.out.print(words[i] + '.');
			    }
				
			    System.out.println(words[0]);
			}
		
	}
	    
      
	
}
