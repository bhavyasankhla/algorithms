/**

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


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
    public int maxDepth(TreeNode root) {
                
            if(root == null) {
                    return 0;
            }
            
            return util(root);
            
    }
        
        public int util(TreeNode node) {
                
                if(node == null ) {
                        return 0;
                }
                
                int lh = util(node.left);
                int rh = util(node.right);
                
                return Math.max(lh, rh) + 1;
                
        }
 }
