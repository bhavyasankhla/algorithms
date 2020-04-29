/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception	{
        String s = "abac";
        
        int result = 0;
        int n = s.length();
        
//         Below is a naive n square solution. 
        
        for( int i = 0; i < n; i++) {
            
            HashMap<Character, Boolean> map = new HashMap<>();
            
            for (int j = i; j < n; j++) {
                
                Character c = s.charAt(j);
                
                if(map.containsKey(c) && map.get(c) == true ) {
                    break; 
                } else {
                    map.put(c, true);
                    result = Math.max(result, j-i+1);
                }
                
            }
        }
        
        // Below is the O(n) solution. 
		
        HashMap<Character, Integer> map = new HashMap<>();
        int maxEnd = 0;
        
        for ( int i = 0; i < n; i++) {
            
            Character c = s.charAt(i);
            
            if(map.containsKey(c)) {
                maxEnd = i - map.get(c); // update maxEnding till that character  by subtracting last occurence of the same char
            } else {
                maxEnd++; // it's a new char hence increment the maxEnding by 1. 
            }     
            
            map.put(c, i); // add entry to map 
            
            result = Math.max(result, maxEnd);
        }
        
        
        System.out.println(result);
	}
}
