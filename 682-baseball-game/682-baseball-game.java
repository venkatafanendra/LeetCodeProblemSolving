class Solution {
    public int calPoints(String[] ops) {
       int n=ops.length;
        int sum=0;
       ArrayList<Integer> res= new ArrayList<>();
       for(int i=0;i<n;i++){
           if(isSpecail(ops[i])==0)
               res.add(Integer.valueOf(ops[i]));
           else{
               switch(isSpecail(ops[i])){
                   case 2 : int x =0,y=0;
                            if(res.size()>0) x = res.get(res.size()-1);
                            if(res.size()>1) y = res.get(res.size()-2);
                            res.add(x+y);
                            break;
                   case 3 : if(res.size()>0)res.add(2*res.get(res.size()-1));
                            break;
                   case 4 : if(res.size()>0)res.remove(res.size()-1);
                            break;
               }
           }
       }
       for(Integer x : res)
           sum+=x;
       return sum; 
    }
    private int isSpecail(String x) {
        if(x.equals("+"))
            return 2;
        else if(x.equals("D"))
            return 3;
        else if(x.equals("C"))
            return 4;
        else
            return 0;
    }
}