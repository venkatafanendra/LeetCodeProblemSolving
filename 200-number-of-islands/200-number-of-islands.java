class Solution {
    int[] dr={0,1,0,-1};
    int[] dc={1,0,-1,0};
    public int numIslands(char[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited= new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(grid,m,n,i,j,visited);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int m,int n,int r,int c,boolean[][] visited){
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            if(isSafe(grid,m,n,r+dr[i],c+dc[i],visited))
                dfs(grid,m,n,r+dr[i],c+dc[i],visited);
        } 
    }
    private boolean isSafe(char[][] grid,int m,int n,int r,int c,boolean[][] visited){
        return r>=0 && c>=0 && r<m && c<n && grid[r][c]=='1' && !visited[r][c];
    }
}