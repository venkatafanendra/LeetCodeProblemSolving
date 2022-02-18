class Solution {
    class Interval{
        int start;
        int end;
        Interval(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public int[][] merge(int[][] intervals) {
        int m=intervals.length;
        Interval[] intvl = new Interval[m];
        for(int i=0;i<m;i++)
            intvl[i]=new Interval(intervals[i][0],intervals[i][1]);
        Arrays.sort(intvl,new Comparator<Interval>() {
            public int compare(Interval i1,Interval i2) {
                return i1.start-i2.start;
            }
        });
        int j = 0;
        for(int i=1;i<m;i++){
            if(intvl[i].start<=intvl[j].end){
                intvl[j].end=Math.max(intvl[i].end,intvl[j].end);
            }
            else{
               j++;
               intvl[j]=intvl[i];
            }
        }
        int[][] finalRes = new int[j+1][2];
        for(int i=0;i<=j;i++){
            finalRes[i][0]=intvl[i].start;
            finalRes[i][1]=intvl[i].end;
        }
        return finalRes;
        
    }
}