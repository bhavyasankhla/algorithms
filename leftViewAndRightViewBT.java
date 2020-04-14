/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class Node { 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 


public class Main {
    Node root;
    static int max_level = 0;
    
    void leftViewUtil(Node node, int level) {
        if(node==null)
            return;
        
        if(level > max_level) {
            System.out.println(node.data);
            max_level = level;
        }
        
        leftViewUtil(node.left, level+1);
        leftViewUtil(node.right, level+1);
        
    }
    
    void leftView() {
        max_level = 0;
        leftViewUtil(root, 1);
    }
    
    void rightViewUtil(Node node, int level) {
        if(node==null)
            return;
        
        if(level > max_level) {
            System.out.println(node.data);
            max_level = level;
        }
        
        rightViewUtil(node.right, level+1);
        rightViewUtil(node.left, level+1);
        
    }
    
    void rightView() {
        max_level = 0;
        rightViewUtil(root, 1);
    }
	
	public static void main (String[] args)  {
	    Main tree = new Main();
	    tree.root = new Node(12); 
        tree.root.left = new Node(10); 
        tree.root.right = new Node(30); 
        tree.root.right.left = new Node(25); 
        tree.root.right.right = new Node(40); 
        tree.leftView(); 
        tree.rightView();
	}
}
