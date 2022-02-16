class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int steps=nums[0];
        int reachable = nums[0];
        int jumps=1;
        for(int i=1;i<n;i++) {
            if(i==n-1)
                return jumps;
            reachable=Math.max(reachable,i+nums[i]);
            steps--;
            if(steps==0) {
                jumps++;
                steps=reachable-i;
            }
        }
        return jumps;
     }
    }
