class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
    adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
}

        
        int[] inorder=new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int it:adj.get(i)){
                inorder[it]++;
            }

        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ;i<inorder.length;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int node=q.poll();
            result[index++]=node;
            
            for(int it : adj.get(node)){
    inorder[it]--;

    if(inorder[it] == 0){
        q.add(it);
    }
}
        }

        if (index==numCourses){
            return result;
        }
        else{
            return new int[0] ;
        }


        
    }
}