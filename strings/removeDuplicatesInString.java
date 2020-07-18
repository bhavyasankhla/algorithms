

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static void removeDuplicates(String str) 
    { 
        LinkedHashSet<Character> lhs = new LinkedHashSet<>(); 
        for(int i=0;i<str.length();i++) 
            lhs.add(str.charAt(i)); 
          
        for(Character ch : lhs) 
            System.out.print(ch); 
    } 
      
    public static void main(String args[]) 
    { 
        String str = "geeksforgeeks"; 
        removeDuplicates(str); 
    } 
}
