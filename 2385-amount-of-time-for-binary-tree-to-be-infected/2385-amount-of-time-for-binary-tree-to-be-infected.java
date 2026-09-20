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
        int distance;

        Pair(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    void markParent(TreeNode root, Map<TreeNode, TreeNode> parent) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }

    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();

        markParent(root, parent);

        TreeNode target = findTarget(root, start);

        Queue<Pair> q = new LinkedList<>();

        Set<TreeNode> visited = new HashSet<>();

        q.add(new Pair(target, 0));
        visited.add(target);

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();
                TreeNode node = p.node;

                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.add(new Pair(node.left, p.distance + 1));
                    burned = true;
                }

                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.add(new Pair(node.right, p.distance + 1));
                    burned = true;
                }

                TreeNode par = parent.get(node);

                if (par != null &&
                    !visited.contains(par)) {

                    visited.add(par);
                    q.add(new Pair(par, p.distance + 1));
                    burned = true;
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }

    public TreeNode findTarget(TreeNode root, int start) {

        if (root == null) {
            return null;
        }

        if (root.val == start) {
            return root;
        }

        TreeNode left = findTarget(root.left, start);

        if (left != null) {
            return left;
        }

        return findTarget(root.right, start);
    }
}