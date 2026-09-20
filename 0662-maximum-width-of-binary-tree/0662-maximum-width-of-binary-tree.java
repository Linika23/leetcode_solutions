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
    class Pair{
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0));
        long maxWidth=0;

        while(!q.isEmpty()){
            long first=q.peek().index;
            long last=first;

            long size=q.size();

            for(int i=0;i<size;i++){
                Pair p=q.poll();
                long curr=p.index;
                last=curr;

                if(p.node.left!=null){
                    q.add(new Pair(p.node.left,2*curr+1));
                }
                if(p.node.right!=null){
                    q.add(new Pair(p.node.right,2*curr+2));
                }

                long width = last-first+1;
                maxWidth=Math.max(width,maxWidth);

            }
        }

        return (int)maxWidth;
        
    }
    
}