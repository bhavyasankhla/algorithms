/**

Symmetric Tree
Easy

5144

124

Add to List

Share
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) {
            
            if(root==null) {
                    return true;
            }
           
            return util(root.left, root.right);
        
    }
        
        public boolean util(TreeNode left, TreeNode right) {
                
                if(left == null || right == null) {
                        return left == right;
                }
                
                if(left.val != right.val) {
                        return false; 
                }
                
                return util(left.left, right.right) && util(left.right, right.left);
                
        }
}
