/**

https://www.youtube.com/watch?v=smjr2ow6oKc


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
            List<List<Integer>> result = new ArrayList<>();            
            
            if(root==null) {
                return result;
            }
            
            Stack<TreeNode> s1 = new Stack<>(); // L to R 
            Stack<TreeNode> s2 = new Stack<>(); // R to L 
            
            s1.push(root);
            
            List<Integer> temp = new ArrayList<>();
            
            while(!s1.isEmpty() || !s2.isEmpty()) {
                                        
                    while(!s1.isEmpty()) {
                            TreeNode n = s1.pop();
                            temp.add(n.val);
                            if(n.left != null) {
                                    s2.push(n.left);
                            }
                            if(n.right != null) {
                                    s2.push(n.right);
                            }
                    }
                    if(!temp.isEmpty())
                        result.add(new ArrayList<>(temp));
                    temp.clear();
                    
                    
                    while(!s2.isEmpty()) {
                            TreeNode n = s2.pop();
                            temp.add(n.val);
                            if(n.right != null) {
                                    s1.push(n.right);
                            }
                            if(n.left != null) {
                                    s1.push(n.left);
                            }
                    }
                    if(!temp.isEmpty())
                        result.add(new ArrayList<>(temp));
                    temp.clear();
                    
            }
            
            
            return result;
    }
}
