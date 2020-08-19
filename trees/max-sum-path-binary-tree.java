/**
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

class Res {
        int val;
}

class Solution {
        
    public int maxPathSum(TreeNode root) {
            if(root == null) {
                    return 0;
            }
            Res result = new Res();
            result.val = root.val;
            maxPathSumUtil(root, result);
            return result.val;        
    }
        
        public int maxPathSumUtil(TreeNode node, Res result) {
                if(node == null) {
                    return 0;
                }
            
                int l = maxPathSumUtil(node.left, result);
                int r = maxPathSumUtil(node.right, result);
                                
                int temp = Math.max(Math.max(l,r) + node.val, node.val);
                
                result.val = Math.max(result.val, Math.max(l+r+node.val, temp));
                
                return temp;
        }
}
