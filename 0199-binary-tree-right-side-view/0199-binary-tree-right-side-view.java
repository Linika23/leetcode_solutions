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
    class Pair {
        TreeNode node;
        int row;

        Pair(TreeNode node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();

            // Rightmost node of each row
            map.put(p.row, p.node.val);

            if (p.node.left != null) {
                q.add(new Pair(p.node.left, p.row + 1));
            }

            if (p.node.right != null) {
                q.add(new Pair(p.node.right, p.row + 1));
            }
        }

        for (Integer value : map.values()) {
            ans.add(value);
        }

        return ans;
    }
}