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

    public boolean findTarget(TreeNode root, int k) {

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        pushLeft(root, leftStack);
        pushRight(root, rightStack);

        while (!leftStack.isEmpty() && !rightStack.isEmpty()
                && leftStack.peek() != rightStack.peek()) {

            int left = leftStack.peek().val;
            int right = rightStack.peek().val;

            int sum = left + right;

            if (sum == k) {
                return true;
            }

            if (sum < k) {
                nextSmallest(leftStack);
            } else {
                nextLargest(rightStack);
            }
        }

        return false;
    }

    // Push nodes for inorder traversal
    private void pushLeft(TreeNode node, Stack<TreeNode> stack) {

        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Push nodes for reverse inorder traversal
    private void pushRight(TreeNode node, Stack<TreeNode> stack) {

        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    // Move to next smallest value
    private void nextSmallest(Stack<TreeNode> stack) {

        TreeNode node = stack.pop();

        if (node.right != null) {
            pushLeft(node.right, stack);
        }
    }

    // Move to next largest value
    private void nextLargest(Stack<TreeNode> stack) {

        TreeNode node = stack.pop();

        if (node.left != null) {
            pushRight(node.left, stack);
        }
    }
}