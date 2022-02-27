class Solution {
    public int compareVersion(String version1, String version2) {
        String x[] = version1.split("\\.");
        String y[] = version2.split("\\.");
        int len=Math.max(x.length,y.length);
        int i;
        for(i=0;i<len;i++){
            Integer v1 = i < x.length ? Integer.parseInt(x[i]) : 0 ;
            Integer v2 = i < y.length ? Integer.parseInt(y[i]) : 0;
            int compare = v1.compareTo(v2);
            if(compare!=0)
                return compare;
        }
        return 0 ;
    }
}