package Traversal_Problems;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //start from the sr,sc index, and perform bfs or dfs and go on changing the color of the non zero nodes
        int prevColor= image[sr][sc];
        image[sr][sc]= color;
        dfs(image, sr,sc,color, prevColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int prevColor){
        if(color==prevColor) return;
        //call dfs for 4 directions
        if(sr-1>=0 && image[sr-1][sc]==prevColor){
            image[sr-1][sc]=color;
            dfs(image, sr-1, sc,color, prevColor);
        }
        if(sr+1<image.length && image[sr+1][sc]==prevColor){
            image[sr+1][sc]=color;
            dfs(image, sr+1, sc, color, prevColor);
        }
        if(sc-1>=0 && image[sr][sc-1]==prevColor){
            image[sr][sc-1]=color;
            dfs(image, sr, sc-1,color, prevColor);
        }
        if(sc+1<image[0].length && image[sr][sc+1]==prevColor){
            image[sr][sc+1]= color;
            dfs(image,sr, sc+1, color, prevColor);
        }
    }
}
