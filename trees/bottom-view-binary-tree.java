// https://www.geeksforgeeks.org/bottom-view-binary-tree/

/**

                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \      
                  10    14 
**/




package trees;
import java.util.*;

class Node {
	int d;
	Node left,right;
	int hd;
	
	public Node(int data) {
		d= data;
		left = null;
		right = null;
		hd=Integer.MAX_VALUE;
	}
}

class Tree {
	
	Node root;
	
	public Tree(Node node) {
		root = node;
	}
	
	public void bottomView() {
		
		if(root == null ) {
			return;
		}
		
		root.hd  = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		
		while(!queue.isEmpty()) {
			
			Node current = queue.remove();			
			treeMap.put(current.hd,  current.d);
			
			if(current.left != null) {				
				Node n = current.left;
				n.hd = current.hd-1;
				queue.add(n);
			}
			
			if(current.right != null) {
				Node n = current.right;
				n.hd = current.hd+1;
				queue.add(n);
			}	 	
			
		}
		
		Set<Map.Entry<Integer, Integer>> set = treeMap.entrySet();
 		
		set.forEach(entry -> {
			System.out.println(entry.getValue());
		});
	
	}
	
	public void levelOrder() {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			
			Node current = q.remove();
			
			if(current == null) {
				
				System.out.println();
				
				if(q.size() > 0) {
					q.add(null);
					continue;
				} else {
					break;
				}
				
			} else {
				System.out.print(current.d + "  ");
			}
			
			if(current.left != null) {				
				Node n = current.left;
				q.add(n);
			}
			
			if(current.right != null) {
				Node n = current.right;				
				q.add(n);
			}	 	
		}
		
	}
	
}

public class BottomView {
	

	public static void main(String[] args) {
		
		Node root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14); 
        
        Tree tree = new Tree(root);
        
        tree.bottomView();
        
        tree.levelOrder();
        
	}

}
