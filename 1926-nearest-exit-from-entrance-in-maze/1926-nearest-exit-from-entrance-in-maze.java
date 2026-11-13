class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int n  = maze.length;
        int m = maze[0].length;


        

        Queue<int[]> q = new ArrayDeque<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int steps=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k= 0;k<size;k++){

                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];

               if (steps > 0 && (r == 0 || r == n - 1 || c == 0 || c == m - 1)) {
                    return steps;
                }

                for(int[] d : dir){
                    int newr = r + d[0];
                    int newc=c +d[1];

                    if(newr>=0 && newr<n && newc>=0 && newc < m && maze[newr][newc]!='+'){
                         q.add(new int[]{newr, newc});
                        maze[newr][newc]='+';
                    }
                }


            }
            steps++;
        }

        return -1;
        
    }
}