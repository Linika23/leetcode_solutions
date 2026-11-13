class Solution {

    private void dfs(int[][] stones,int index, boolean[] visited){
        visited[index]=true;
        for(int i = 0;i<stones.length;i++){
            int r = stones[index][0];
            int c= stones[index][1];

            if(!visited[i] && (stones[i][0]==r || stones[i][1]==c)){
                visited[i]=true;
                dfs(stones,i,visited);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n  = stones.length;
        boolean[] visited = new boolean[n];
        int groups = 0;
         for(int i = 0;i<n;i++){
            if(visited[i]){
                continue;
            }
            dfs(stones,i,visited);

            groups++;
         }

         return n - groups;
        
    }
}