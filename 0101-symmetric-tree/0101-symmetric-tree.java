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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;

        if (left.val != right.val)
            return false; // Base Case: If either left or right is null, return true only if both are null

        return isSymmetricHelp(left.left, right.right) // checks the outer symmetry 
                &&
                isSymmetricHelp(left.right, right.left); // while this function check the inner symmetry
    }
}