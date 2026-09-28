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
    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        
        if (root == null) {
            return -1;
        }

        // Go left
        kthSmallest(root.left, k);

        // Visit current node
        count++;

        if (count == k) {
            answer = root.val;
            return answer;
        }

        // Go right
        kthSmallest(root.right, k);

        return answer;
    }
}