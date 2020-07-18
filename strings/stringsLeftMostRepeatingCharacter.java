// Given a string, find the leftmost character that repeats.
 

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main2 (String[] args) throws java.lang.Exception
	{
		String s = "geeksforgeeks";
		
		char[] ch = s.toCharArray();
		
		int n = s.length();
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		int result = Integer.MAX_VALUE; // this will store the left most index of the Character which repeats.
		
		// map will contain reference to Character and it's index of first occurence. 
		
		for ( int i = 0; i < n; i++ ) {
		    
		    if(map.containsKey(ch[i])) {
		        result = Math.min(result, map.get(ch[i]));
		    } else {
		        map.put(ch[i], i);
		    }
		    
		}
		
		if(result == Integer.MAX_VALUE) {
		    result = -1;
		}
		
		System.out.println(result);
	}
	
		// optimised approach 
	
		public static void main (String[] args) throws java.lang.Exception
	{
		String s = "geeksforgeeks";
		char[] ch = s.toCharArray();
		int n = s.length();
		
		int[] presentChars = new int[256];
		Arrays.fill(presentChars, -1);
		// array to keep count if the character is present in s. 
		
		int result = -1;
		
		for( int i = n-1; i>=0; i--) {
		    
		    Integer j = (int) ch[i]; // ascii value of the Character 
		    
		    if( presentChars[j] == -1 ) {
		        presentChars[j] = i;
		    } else {
		        // Character is appearing more than one time. 
		        // Updating result while traversing from right to left. 
		        // this stores the leftmost index of the char which is repeating
		        result = i;
		    }
		}
		
		if(result == -1) {
		    System.out.println("No repeating Character");
		} else {
		    System.out.println(ch[result]);
		}
	}
}
