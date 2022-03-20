class Solution {
    public void solveSudoku(char[][] board) {
        sudokuHelper(board);
    }
    private boolean sudokuHelper(char[][] board){
        int n = 9;
        int row = -1;
        int col=-1;
        boolean isEmpty=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }
        if(isEmpty)
            return true;
        for(int num=1;num<=n;num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=(char)(num+'0');
                if(sudokuHelper(board))
                    return true;
                else
                    board[row][col]='.';
            }
        }
        return false;
    }
    private boolean isSafe(char[][] board,int row,int col,int num){
        //Column clash
        for(int i=0;i<board.length;i++)
            if(board[i][col]==(char)(num+'0'))
                return false;
        //Row clash
        for(int i=0;i<board.length;i++)
            if(board[row][i]==(char)(num+'0'))
                return false;
        //Subgrid clash
        int rowStart = row - row%3;
        int colStart = col - col%3;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i+rowStart][j+colStart]==(char)(num+'0'))
                    return false;
        return true;
    }
}