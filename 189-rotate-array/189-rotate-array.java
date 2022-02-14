class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        k=n-k;
        int d = calcGCD(k,n);
        for(int i=0;i<d;i++) {
            int temp=nums[i];
            int j=i;
            while(true) {
                int kn = j+k;
                if(kn>=n)
                    kn=kn-n;
                if(kn==i)
                    break;
                nums[j]=nums[kn];
                j=kn;
            }
            nums[j]=temp;
        }
    }
    private int calcGCD(int n,int k) {
        if(k==0)
            return n;
        return calcGCD(k,n%k);
    }
}