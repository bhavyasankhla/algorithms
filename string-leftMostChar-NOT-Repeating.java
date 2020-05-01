// Given a string, find the leftmost character that does not repeat.
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
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
}
