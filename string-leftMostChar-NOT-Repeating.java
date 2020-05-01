// Given a string, find the leftmost character that does not repeat.
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main2 (String[] args) throws java.lang.Exception
	{
		String s = "geeksforgeeks";
		char[] ch = s.toCharArray();
		int n = s.length();
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		
		// map will contain reference to Character and number of times it appeared. 
		
		for ( int i = 0; i < n; i++ ) {
		    
		    if(map.containsKey(ch[i])) {
		        map.put(ch[i],map.get(ch[i])+1);
		    } else {
		        map.put(ch[i],1);
		    }
		    
		}
		
        for( Character key : map.keySet() ) {
            if(map.get(key) == 1) {
                System.out.println(key);
                break;
            }
        }
		
	}
	
	// OPTIMISED APPROACH 
	
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
		        result = i;
		        
	          // Character is appearing first time. 
		        // Updating result while traversing from right to left. 
		        // this stores the leftmost index of the char which is NOT repeating
		    } 
		}
		
		if(result == -1) {
		    System.out.println("No repeating Character");
		} else {
		    System.out.println(ch[result]);
		}
	}
}
