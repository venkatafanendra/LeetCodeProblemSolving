class Solution {
    public void nextPermutation(int[] a) {
        int n = a.length;
        if(n==1)
            return;
        int i,j;
        for(i=n-2;i>=0;i--){
            if(a[i]<a[i+1])
              break;
        }
        if(i==-1)
        {
            Arrays.sort(a);
            return;
        }
        int temp=Integer.MAX_VALUE;
        int k;
        for(j=i+1;j<n;j++){
            if(a[j]>a[i]&&temp>=a[j]) 
                temp=a[j];
            else 
                break;
        }
        int var=a[i];
        a[i]=a[j-1];
        a[j-1]=var;
        Arrays.sort(a,i+1,n);
        
        
    }
}