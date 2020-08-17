/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // base condition 
            if(root == null ) {
                    return null;
            }
            
            //if match found 
            if(root.val == p.val || root.val == q.val){
                    return root;
            }
         
            // leaf node condition
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
  
            // if both left and right are not null, this is the LCA
            if(left != null && right != null){
                    return root;
            }
            
            if(left != null) {
                    return left;
            }
            
             if(right != null) {
                    return right;
            }
            
           return null;
    }
        
}
