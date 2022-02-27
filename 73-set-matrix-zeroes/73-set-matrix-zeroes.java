class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dr[]=new int[m];
        int dc[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    dr[i]=1;
                    dc[j]=1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dr[i]==1 || dc[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}