class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        int matrix[][] = new int[numRows][numRows];
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        res.add(temp);
        for(int i=1;i<numRows;i++){
            List<Integer> resin = new ArrayList<>();
            resin.add(1);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    continue;
                resin.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            resin.add(1);
            res.add(resin);
        }
        return res;
    }
}