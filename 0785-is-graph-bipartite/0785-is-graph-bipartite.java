class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color= new int[n];
        Arrays.fill(color,-1);

        for(int start = 0;start<n;start++){
            if(color[start]!=-1) continue;

            Queue<Integer> q= new LinkedList<>();
            q.add(start);
            color[start]=0;


            while(!q.isEmpty()){
                int node = q.poll();
                for(int neighbour : graph[node]){
                    if(color[neighbour]==-1){
                        color[neighbour]=1-color[node];
                        q.add(neighbour);
                    }
                    else if(color[neighbour]==color[node]){
                        return false;
                    }
                }
            }

        }
        return true;
        
    }
}