/**. 

https://www.youtube.com/watch?v=5lWJpTEnyow&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF


Construct Binary Tree from Preorder and Postorder Traversal
Medium

1032

55

Add to List

Share
Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
 

Note:

1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.


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

        public TreeNode constructFromPrePost(int[] pre, int[] post) {
                return dfs(pre, 0, pre.length - 1, post, 0, pre.length - 1);
        }
        
        private TreeNode dfs(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {        
                if (preStart > preEnd) return null;
                TreeNode root = new TreeNode(pre[preStart]);
                if (preStart == preEnd) return root;
                int postIndex = postStart;
                while (post[postIndex] != pre[preStart + 1]) postIndex++;
                int len = postIndex - postStart + 1;
                root.left = dfs(pre, preStart + 1, preStart + len, post, postStart, postIndex);
                root.right = dfs(pre, preStart + len + 1, preEnd, post, postIndex + 1, postEnd - 1);
                return root;
        }
}
