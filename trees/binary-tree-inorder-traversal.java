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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> l = new ArrayList<>();
            inorderTraversalUtil(root, l);
            return l;
    }
        
        public void inorderTraversalUtil(TreeNode node, List<Integer> list) {
                if(node==null) {
                        return;
                }
                inorderTraversalUtil(node.left, list);
                list.add(node.val);
                inorderTraversalUtil(node.right, list);                
        }
        
        
}
