// Given a string, find the leftmost character that does NOT repeat.

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
	public static void main2 (String[] args) throws java.lang.Exception	{
		String s = "geeksforgeeks";
		char[] ch = s.toCharArray();
		int n = s.length();		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();		
		// map will contain reference to Character and number of times it appeared. 
		// since it is linkedhashmap, the chars are stored in insertion order.
		
		for ( int i = 0; i < n; i++ ) {		    
		    if(map.containsKey(ch[i])) {
		        map.put(ch[i],map.get(ch[i])+1);
		    } else {
		        map.put(ch[i],1);
		    }		    
		}
		
		map.forEach( (k,v) -> {
			if(v == 1) {
				System.out.println(k);
				break;
		    	}
		});		
	}
	
	// ANOTHER APPROACH WITHOUT USING HASHMAP 
	
	public static void main (String[] args) throws java.lang.Exception {
		String s = "geeksforgeeks";
		char[] ch = s.toCharArray();
		int n = s.length();
		
		int[] presentChars = new int[256];
		Arrays.fill(presentChars, -1);
		// array to keep count if the character is present in s. 
		
		int result = Integer.MAX_VALUE;
		
		for( int i = 0; i < n; i++) {
		    
		    Integer j = (int) ch[i]; // ascii value of the Character 
		    
		    if( presentChars[j] == -1 ) {
		        presentChars[j] = i;
	          	// Character is appearing first time. 
		    } else {
		        // The Character is repeating
		        presentChars[j] = -2; // not -1 because if it occurs third time, the program will consider it as first occurence. 
		    }
		}
		
		for (int i = 0; i < 256 ; i++) {
		    if(presentChars[i] >= 0) {
		        result = Math.min(result, presentChars[i]);
		    }
		}
		
		if(result == Integer.MAX_VALUE) {
		    System.out.println("No repeating Character");
		} else {
		    System.out.println(ch[result]);
		}
	}
}
