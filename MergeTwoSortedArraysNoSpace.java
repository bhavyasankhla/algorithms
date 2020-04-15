/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		int a = scanner.nextInt();
		
		while(a-- > 0) {
		    int b = scanner.nextInt();
		    int c = scanner.nextInt();
		    
		    int[] a1 = new int[b];
		    int[] a2 = new int[c];
		    int i= 0;
		    for(i = 0; i<b;i++) {
		        a1[i] = scanner.nextInt();
		    }
		    
		    for( i = 0; i<c;i++) {
		        a2[i] = scanner.nextInt();
		    }
		    
		    i = b-1;
		    int j=0;
		    
		    while(i >= 0 && j<c) {
		        if(a1[i] > a2[j]) {
		            int temp = a1[i];
		            a1[i] = a2[j];
		            a2[j] = temp;
		        } else {
		            break;
		        }
		        i--;
		        j++;
		    }
		    
		    Arrays.sort(a1);
		    Arrays.sort(a2);
		    
		    for( i = 0; i<b;i++) {
		        System.out.print(a1[i]);
		        System.out.print(" ");
		    }
		    
		    System.out.println();
		    
		    for( i = 0; i<c;i++) {
		        System.out.print(a2[i]);
		        System.out.print(" ");
		    }
		    
		    System.out.println();
		    
		}
	}
	
	
}
