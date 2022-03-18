class Solution {
    public int minimumCost(int[] cost) {
        int exist[] =new int[201];
        for(int i=0;i<cost.length;i++){
            exist[cost[i]+100]++;
        }
        int sum=0;
        int first=0;
        for(int i=exist.length-1;i>0;i--){
            while(exist[i]>0){
                if(first==2){
                    first=0;
                }else{
                    sum = sum+i-100;
                    first++;
                }
                exist[i]--;
            }
        }
        return sum;
    }
}