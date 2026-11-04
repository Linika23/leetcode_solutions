class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;

        int cols=grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int fresh=0;

        for(int i =0;i<=rows-1;i++){

            for(int j=0;j<=cols-1;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){

                    fresh++;
                }
                
            }
        }

        int[] dr ={1,-1,0,0};
        int[] dc={0,0,1,-1};

        int time=0;

        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] cell = q.poll();
                for(int d=0;d<4;d++){
                    int r = cell[0] + dr[d];
                    int c=cell[1] + dc[d];

                    if(r>=0 && c>=0 && r<rows && c<cols && grid[r][c]==1){
                        grid[r][c]=2;
                        fresh--;
                        q.add(new int[]{r,c});

                    }
                }
            }

            time++;
        }

        return fresh==0?time:-1;

        
        
    }

}