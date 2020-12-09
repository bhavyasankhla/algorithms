/**

Construct Binary Tree from Preorder and Inorder Traversal
Medium

4341

112

Add to List

Share
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7



 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            
            return helper( 0, 0, inorder.length-1, preorder, inorder);
        
    }
        
        public TreeNode helper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
                
                if(preStart > preOrder.length-1 || inStart > inEnd) {
                        return null;
                }
                
                TreeNode root = new TreeNode(preOrder[preStart]);
                
                // First element in preorder is the root
                // find the root in inorder (L,root,R) to separate left and right sub trees
                
                int rootIndexInorder = 0;
                
                for(int i =0 ; i < inOrder.length; i++) {
                        if(inOrder[i] == root.val) {
                              rootIndexInorder = i;
                                break;
                        }
                }
                
                root.left = helper(preStart+1, inStart, rootIndexInorder-1, preOrder, inOrder);
                
                root.right = helper(preStart + rootIndexInorder - inStart + 1, rootIndexInorder + 1, inEnd, preOrder, inOrder);
                
                // root.right preStart should be all the elements before the rootIndex in inorder + 1
                
                return root;
        }
}
