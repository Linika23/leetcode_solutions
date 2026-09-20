/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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

    // Step 1: parent map banana
    public void markParents(TreeNode root,
                            Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                q.add(node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root,
                                   TreeNode target,
                                   int k) {

        List<Integer> ans = new ArrayList<>();

        // Parent map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        // Visited
        Set<TreeNode> visited = new HashSet<>();

        // BFS
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(target, 0));
        visited.add(target);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                // K distance reached
                if (p.distance == k) {
                    ans.add(p.node.val);
                    continue;
                }

                // Left
                if (p.node.left != null &&
                    !visited.contains(p.node.left)) {

                    visited.add(p.node.left);
                    q.add(new Pair(p.node.left,
                                   p.distance + 1));
                }

                // Right
                if (p.node.right != null &&
                    !visited.contains(p.node.right)) {

                    visited.add(p.node.right);
                    q.add(new Pair(p.node.right,
                                   p.distance + 1));
                }

                // Parent
                TreeNode parent = parentMap.get(p.node);

                if (parent != null &&
                    !visited.contains(parent)) {

                    visited.add(parent);
                    q.add(new Pair(parent,
                                   p.distance + 1));
                }
            }
        }

        return ans;
    }
}