// Given a string, find the leftmost character that repeats.
 

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
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
}
