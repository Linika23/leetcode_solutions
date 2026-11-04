class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original==color) return image;

        dfs(sr,sc,color,image,original);
        return image;


        
    }

    private void dfs(int i,int j, int color, int[][] image,int original){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j]!=original){
            return;
        }
         image[i][j]=color;

         dfs(i+1,j,color,image,original);
         dfs(i-1,j,color,image,original);
         dfs(i,j+1,color,image,original);
         dfs(i,j-1,color,image,original);
        

    } 

}
