class Solution {
    class Job {
        int startTime;
        int endTime;
        int profit;
        public Job(int startTime,int endTime,int profit) {
            this.startTime=startTime;
            this.endTime=endTime;
            this.profit=profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxProfit = 0;
        int n = profit.length;
        Job job[]=new Job[n];
        for(int i=0;i<n;i++){
           job[i] = new Job(startTime[i],endTime[i],profit[i]); 
        }
        Arrays.sort(job,(a,b)-> {
            return a.endTime-b.endTime;
        });
        int table[] = new int[n];
        table[0]=job[0].profit;
        for(int i=1;i<n;i++) {
            int inclProf = job[i].profit;
            int l = binarySearch(job,i);
            if(l!=-1)
                inclProf+=table[l];
            table[i]=Math.max(inclProf,table[i-1]);
        } 
    return table[n-1];
    }
    private int binarySearch(Job[] job,int i) {
        int low=0;
        int high=i-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(job[mid].endTime<=job[i].startTime){
                if(job[mid+1].endTime<=job[i].startTime)
                    low=mid+1;
                else
                    return mid;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
    }
}