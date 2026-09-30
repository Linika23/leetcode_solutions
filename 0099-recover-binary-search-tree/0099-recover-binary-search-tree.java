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

    public void recoverTree(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Go as left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Take the next inorder node
            curr = stack.pop();

            // Check violation
            if (prev != null && prev.val > curr.val) {

                if (first == null) {
                    first = prev;
                }

                second = curr;
            }

            // Current becomes previous
            prev = curr;

            // Move right
            curr = curr.right;
        }

        // Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}