class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        partitionUtil(s,res,temp,0);
        return res;   
    }
    private void partitionUtil(String s,List<List<String>> res,List<String> temp,int start){
        if(start==s.length()){
            res.add(new ArrayList<>(temp));
        }else {
            for(int i=start;i<s.length();i++){
                if(isPalindrome(s,start,i)){
                    temp.add(s.substring(start,i+1));
                    partitionUtil(s,res,temp,i+1);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    private boolean isPalindrome(String s ,int start, int end) {
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}