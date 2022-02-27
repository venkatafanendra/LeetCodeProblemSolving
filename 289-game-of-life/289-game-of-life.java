class Solution {
    int row[] = {0,1,1,1,0,-1,-1,-1};
    int col[] = {1,1,0,-1,-1,-1,0,1};
    private boolean isSafe(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n ;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int dr[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live=0;
                for(int k=0;k<8;k++){
                    int nexti=i+row[k];
                    int nextj=j+col[k];
                    if(isSafe(nexti,nextj,m,n) && board[nexti][nextj]==1)
                        live++;
                }
                if(live==2)
                    dr[i][j]=board[i][j];
                else if(live==3 )
                    dr[i][j]=1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=dr[i][j];
            }
        }        
    }
}