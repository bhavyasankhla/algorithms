/**

https://www.youtube.com/watch?v=12omz-VAyRk&ab_channel=NickWhite

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/


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
    public TreeNode sortedArrayToBST(int[] nums) {
            
            if(nums.length==0) {
                    return null;
            }
            
            return constructTreeFromArray(nums, 0, nums.length-1);
            
    }
        
        public TreeNode constructTreeFromArray(int[] nums, int left, int right) {
                
                if(left>right) {
                        return null;
                }
                
                int middle = left + (right-left)/2;
                TreeNode m = new TreeNode(nums[middle]);
                
                m.left = constructTreeFromArray(nums, left, middle-1);
                m.right = constructTreeFromArray(nums, middle+1, right);
                
                return m;
        }
}
