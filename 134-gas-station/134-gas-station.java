class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(n==1 && gas[0]>=cost[0])
            return 0;
        if(n==1 && gas[0]<cost[0])
            return -1;
        int start=0;
        int end=1;
        int currGas = gas[start]-cost[start];
        while(end!=start || currGas<0){
            while(currGas<0 && start!=end){
                currGas=currGas-(gas[start]-cost[start]);
                start = (start+1)%n;
                if(start==0)
                    return -1;
            }
            currGas = currGas + gas[end]-cost[end];
            end = (end+1)%n;
        }
        return start;
    }
}