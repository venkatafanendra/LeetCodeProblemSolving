class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res= new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(0,res,board);
        return res;
        
    }
    private void solve(int col,List<List<String>> res,char[][] board){
       if(col==board.length){
           List<String> resin = new ArrayList<>();
           for(int i=0;i<board.length;i++){
               String s = new String(board[i]);
               resin.add(s);
           }
           res.add(resin);
           return;
       }
       for(int i=0;i<board.length;i++){
           if(validate(board,i,col)){
               board[i][col]='Q';
               solve(col+1,res,board);
               board[i][col]='.';
           }
       }
       
    }
    private boolean validate(char[][] board,int row,int col) {
        int storerow=row;
        int storecol=col;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q')
                return false;
            row--;
            col--;
        }
        row=storerow;
        col=storecol;
        while(col>=0){
            if(board[row][col]=='Q')
                return false;
            col--;
        }
        row=storerow;
        col=storecol;
        while(row<board.length && col>=0){
            if(board[row][col]=='Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
    
}