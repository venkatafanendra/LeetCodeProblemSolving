class Solution {
    class Pairs { 
        int first;
        int second;
        Pairs(int first,int second) {
            this.first=first;
            this.second=second;
        }
    }
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        Pairs pairclass[] = new Pairs[n];
        for(int i=0;i<pairs.length;i++) {
            pairclass[i]=new Pairs(pairs[i][0],pairs[i][1]);
        }
        Arrays.sort(pairclass, (a,b)-> a.second-b.second );
        int table[]=new int[n];
        Arrays.fill(table,1);
        for(int i=1;i<n;i++) {
            int l = binarySearch(pairclass,i);
            if(l!=-1) {
                table[i]=Math.max(table[l]+1,table[i-1]);
            } 
            table[i]=Math.max(table[i],table[i-1]);
        }
        return table[n-1];
    }
    private int binarySearch(Pairs p[],int index) {
        int low=0;
        int high=index-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(p[mid].second<p[index].first) {
                if(p[mid+1].second<p[index].first){
                    low=mid+1;
                }
                else {
                    return mid;
                }
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}