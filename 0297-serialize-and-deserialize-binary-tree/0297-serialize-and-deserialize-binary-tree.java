/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "n";
        Queue<TreeNode>q=new LinkedList<>();
        StringBuilder res=new StringBuilder();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                 res.append("n ");
                 continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);

        }

        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if (data.equals("n")) return null;

    String[] value = data.split(" ");

    TreeNode root = new TreeNode(Integer.parseInt(value[0]));

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int i = 1;

    while (!q.isEmpty() && i < value.length) {
        TreeNode parent = q.poll();

        // Left child
        if (!value[i].equals("n")) {
            TreeNode left = new TreeNode(Integer.parseInt(value[i]));
            parent.left = left;
            q.add(left);
        }
        i++;

        // Right child
        if (i < value.length && !value[i].equals("n")) {
            TreeNode right = new TreeNode(Integer.parseInt(value[i]));
            parent.right = right;
            q.add(right);
        }
        i++;
    }

    return root;
}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));