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

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {

        // dono null hain
        if (left == null && right == null) {
            return true;
        }

        // ek null hai, doosra nahi
        if (left == null || right == null) {
            return false;
        }

        // values same nahi hain
        if (left.val != right.val) {
            return false;
        }

        // mirror positions compare karo
        return isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }
}