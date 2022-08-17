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
    public TreeNode pruneTree(TreeNode root) {
        prune(root);
        return root.right == null && root.left == null && root.val == 0 ? null : root;
    }
    
    public boolean prune(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean pruneLeft = prune(root.left);
        boolean pruneRight = prune(root.right);
        if (pruneLeft) {
            root.left = null;
        }
        if (pruneRight) {
            root.right = null;
        }
        return root.val != 1 && pruneLeft && pruneRight;
    }
}